package org.skraua.service;

import org.skraua.dto.UserDTO;
import org.skraua.pojo.User;
import org.skraua.utils.ResultVo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/01
 * @description
 */
public interface UserService extends IService<User> {
    public ResultVo<UserDTO> login(String username, String password) throws Exception;

    public ResultVo<Void> add(UserDTO userDTO, String passward) throws Exception;

    public ResultVo<Void> update(UserDTO userDTO, String passward, String newPassward) throws Exception;

    public ResultVo<Void> remove(Integer id, String passward) throws Exception;
}
