package org.skraua.service;

import java.util.List;

import org.skraua.pojo.Menu;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/08
 * @description
 */
public interface RouteService extends IService<Menu> {

    public List<Menu> getRoutesByRoleIds(List<Integer> roleIds) throws Exception;
}
