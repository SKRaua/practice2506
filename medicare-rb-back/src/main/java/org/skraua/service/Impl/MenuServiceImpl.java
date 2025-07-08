package org.skraua.service.Impl;

import org.skraua.pojo.Menu;
import org.skraua.service.MenuService;
import org.skraua.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/07
 * @description
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
