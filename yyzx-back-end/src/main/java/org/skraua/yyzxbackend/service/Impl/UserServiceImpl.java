package org.skraua.yyzxbackend.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.skraua.yyzxbackend.dto.UserDTO;
import org.skraua.yyzxbackend.mapper.MenuMapper;
import org.skraua.yyzxbackend.mapper.RoleMenuMapper;
import org.skraua.yyzxbackend.mapper.UserMapper;
import org.skraua.yyzxbackend.pojo.Menu;
import org.skraua.yyzxbackend.pojo.RoleMenu;
import org.skraua.yyzxbackend.pojo.User;
import org.skraua.yyzxbackend.service.UserService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Zhou Xinyang
 * @date 2025/07/01
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public ResultVo<User> login(String username, String password) throws Exception {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", username);
        qw.eq("password", password);
        User user = getOne(qw);
        System.out.println(user);
        if (user != null) {
            if (user.getIsDeleted() == 0) {
                // 根据用户角色获取当前用户的菜单
                // 获取得到角色对应的menu_id
                QueryWrapper<RoleMenu> listRoleQw = new QueryWrapper<>();
                listRoleQw.eq("role_id", user.getRoleId());
                listRoleQw.select("menu");
                List<Integer> menuIds = roleMenuMapper.selectObjs(listRoleQw)
                        .stream()
                        .map(obj -> (Integer) obj)
                        .collect(Collectors.toList()); // 管理员 1 2 3 4 5 6

                // 根据menu_id查询一级菜单列表
                List<Menu> menus = menuMapper.selectBatchIds(menuIds); // 1床位管理 2客户管理 4 5 6
                // 查询子菜单
                for (Menu menu : menus) {
                    QueryWrapper<Menu> listMenuQw = new QueryWrapper<>();
                    listMenuQw.eq("parent_id", menu.getId()); // 1
                    menu.setChildren(menuMapper.selectList(listMenuQw));
                }
                user.setMenuList(menus);
                HashMap<String, Object> map = new HashMap<>();
                // 如果登录验证成功,则需要生成令牌token（token就是按照特定规则生成的字符串）
                JwtBuilder builder = Jwts.builder();
                String token = builder.setSubject(username) // 主题，就是token中携带的数据
                        .setIssuedAt(new Date()) // 设置token的生成时间
                        .setId(user.getId().toString()) // 设置用户id为token id
                        .setClaims(map) // map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 设置过期时间
                        .signWith(SignatureAlgorithm.HS256, "cqupt123456") // 设置加密方式和加密密钥
                        .compact();
                return ResultVo.ok(user, token);
            }
            return ResultVo.fail("无权限，请联系管理员");
        }
        return ResultVo.fail("账号密码错误");
    }

    @Override
    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception {
        Page<User> myPage = new Page<>(userDTO.getPageSize(), 3);
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (userDTO.getNickname() != null && !"".equals(userDTO.getNickname())) {
            qw.like("nickname", "%" + userDTO.getNickname() + "%");
        }
        qw.eq("role_id", userDTO.getRoleId());
        qw.eq("is_deleted", 0);
        page(myPage, qw);
        return ResultVo.ok(myPage);
    }

    @Override
    public ResultVo<Page<User>> listPage(UserDTO userDTO) throws Exception {
        Page<User> myPage = new Page<>(userDTO.getPageSize(), 3);
        QueryWrapper<User> qw = new QueryWrapper<>();
        page(myPage, qw);
        return ResultVo.ok(myPage);
    }

    @Override
    public ResultVo<Void> add(User user) throws Exception {
        user.setIsDeleted(0);
        baseMapper.insert(user);
        return ResultVo.ok("添加成功");
    }

    @Override
    public ResultVo<Void> update(User user) throws Exception {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId());
        baseMapper.update(user, updateWrapper);
        return ResultVo.ok("修改成功");
    }

}
