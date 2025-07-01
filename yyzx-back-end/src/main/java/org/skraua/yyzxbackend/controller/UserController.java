package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.dto.UserDTO;
import org.skraua.yyzxbackend.pojo.Room;
import org.skraua.yyzxbackend.pojo.User;
import org.skraua.yyzxbackend.service.RoomService;
import org.skraua.yyzxbackend.service.UserService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedUsageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zhou Xinyang
 * @date 2025/07/01
 * @description
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户登录账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户登录密码", required = true)
    })
    @GetMapping("/login")
    public ResultVo<User> login(String username, String password) throws Exception {
        return userService.login(username, password);
    }

    @ApiOperation("查询系统用户-分页")
    @GetMapping("/findUserPage")
    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception {
        return userService.findUserPage(userDTO);
    }

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/listPage")
    public ResultVo<Page<User>> listPage(UserDTO userDTO) throws Exception {
        return userService.listPage(userDTO);
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public ResultVo<Void> add(User user) throws Exception {
        return userService.add(user);
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ResultVo<Void> update(User user) throws Exception {
        return userService.update(user);
    }

    @ApiOperation("删除用户无标记移除)")
    @PostMapping("/remove")
    public ResultVo<Void> delete(Integer id) throws Exception {
        userService.removeById(id);
        return ResultVo.ok("删除成功");
    }
}
