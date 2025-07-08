package org.skraua.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.skraua.dto.UserDTO;
import org.skraua.mapper.MenuMapper;
import org.skraua.mapper.RoleMenuMapper;
import org.skraua.mapper.UserMapper;
import org.skraua.pojo.Menu;
import org.skraua.pojo.RoleMenu;
import org.skraua.pojo.User;
import org.skraua.service.UserService;
import org.skraua.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Zhou Xinyang
 * @date 2025/07/07
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public ResultVo<UserDTO> login(String username, String password) throws Exception {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", username);
        qw.eq("password", password);
        User user = getOne(qw);
        if (user != null) {
            // 根据用户角色获取当前用户的菜单
            // 获取得到角色对应的menu_id
            QueryWrapper<RoleMenu> listRoleQw = new QueryWrapper<>();
            listRoleQw.eq("role_id", user.getRoleId());
            listRoleQw.select("menu");
            List<Integer> menuIds = roleMenuMapper.selectObjs(listRoleQw)
                    .stream()
                    .map(obj -> (Integer) obj)
                    .collect(Collectors.toList()); // 管理员 

            // 根据menu_id查询一级菜单列表
            List<Menu> menus = menuMapper.selectBatchIds(menuIds); // 
            // 查询子菜单
            for (Menu menu : menus) {
                QueryWrapper<Menu> listMenuQw = new QueryWrapper<>();
                listMenuQw.eq("parent_id", menu.getId()); // 1
                menu.setChildren(menuMapper.selectList(listMenuQw));
            }
            UserDTO userDTO = new UserDTO();
            userDTO.setMenuList(menus);

            // 生成token
            HashMap<String, Object> map = new HashMap<>();
            userDTO.setId(user.getId());
            userDTO.setNickname(user.getNickname());
            userDTO.setUsername(user.getUsername());
            userDTO.setRoleId(user.getRoleId());
            // 如果登录验证成功,则需要生成令牌token（token就是按照特定规则生成的字符串）
            JwtBuilder builder = Jwts.builder();
            String token = builder.setSubject(username) // 主题，就是token中携带的数据
                    .setIssuedAt(new Date()) // 设置token的生成时间
                    .setId(userDTO.getId().toString()) // 设置用户id为token id
                    .setClaims(map) // map中可以存放用户的角色权限信息
                    .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 设置过期时间
                    .signWith(SignatureAlgorithm.HS256, "skraua2025") // 设置加密方式和加密密钥
                    .compact();
            return ResultVo.ok(userDTO, token);
        }
        return ResultVo.fail("登录失败，检查账号密码");
    }

    @Override
    public ResultVo<Void> add(UserDTO userDTO, String passward) throws Exception {
        User user = new User();
        user.setNickname(userDTO.getNickname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passward);
        user.setRoleId(userDTO.getRoleId());
        userMapper.insert(user);
        return ResultVo.ok("添加成功");
    }

    @Override
    public ResultVo<Void> update(UserDTO userDTO, String passward, String newPassward) throws Exception {
        User user = userMapper.selectById(userDTO.getId());
        if (!user.getPassword().equals(passward)) {
            return ResultVo.fail("密码错误");
        }
        user.setId(userDTO.getId());
        user.setPassword(newPassward);
        user.setUsername(userDTO.getUsername());
        user.setNickname(userDTO.getNickname());
        user.setRoleId(userDTO.getRoleId());
        userMapper.updateById(user);
        return ResultVo.ok("修改成功");
    }

    @Override
    public ResultVo<Void> remove(Integer id, String passward) throws Exception {
        User user = userMapper.selectById(id);
        if (!user.getPassword().equals(passward)) {
            return ResultVo.fail("密码错误");
        }
        userMapper.deleteById(id);
        return ResultVo.ok("修改成功");
    }

}
