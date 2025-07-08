package org.skraua.service.Impl;

import org.skraua.mapper.RoleMapper;
import org.skraua.pojo.Role;
import org.skraua.service.RoleService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/07
 * @description
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
