package org.skraua.controller;

import org.skraua.dto.UserDTO;
import org.skraua.service.UserService;
import org.skraua.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
    public ResultVo<UserDTO> login(String username, String password) throws Exception {
        return userService.login(username, password);
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(dataType = "string", name = "nickname", value = "用户昵称", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户登录密码", required = true),
            @ApiImplicitParam(dataType = "int", name = "roleId", value = "用户角色编号", required = true)
    })
    @PostMapping("/add")
    public ResultVo<Void> add(UserDTO userDTO, String passward) throws Exception {
        return userService.add(userDTO, passward);
    }

    @ApiOperation("修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户编号", required = true),
            @ApiImplicitParam(dataType = "string", name = "passward", value = "密码", required = true),
            @ApiImplicitParam(dataType = "string", name = "newPassward", value = "新密码", required = true),
            @ApiImplicitParam()
    })
    @PostMapping("/update")
    public ResultVo<Void> update(UserDTO userDTO, String passward, String newPassward) throws Exception {
        return userService.update(userDTO, passward, newPassward);
    }

    @ApiOperation("删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "id", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "string", name = "passward", value = "密码", required = true)
    })
    @PostMapping("/remove")
    public ResultVo<Void> remove(Integer id, String passward) throws Exception {
        return userService.remove(id, passward);
    }
}
