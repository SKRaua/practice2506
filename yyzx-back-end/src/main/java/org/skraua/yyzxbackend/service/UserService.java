package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.UserDTO;
import org.skraua.yyzxbackend.pojo.User;
import org.skraua.yyzxbackend.utils.ResultVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/01
 * @description
 */
public interface UserService extends IService<User> {
    public ResultVo<User> login(String username, String password) throws Exception;

    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception;

    public ResultVo<Page<User>> listPage(UserDTO userDTO) throws Exception;

    public ResultVo<Void> add(User user) throws Exception;

    public ResultVo<Void> update(User user) throws Exception;
}
