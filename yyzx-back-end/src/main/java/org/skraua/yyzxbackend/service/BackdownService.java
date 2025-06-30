package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.BackdownDTO;
import org.skraua.yyzxbackend.pojo.Backdown;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BackdownVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
public interface BackdownService extends IService<Backdown> {
    ResultVo<Page<BackdownVo>> listPage(BackdownDTO backdownDTO) throws Exception;
}
