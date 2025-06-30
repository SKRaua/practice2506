package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.BackdownDTO;
import org.skraua.yyzxbackend.mapper.BackdownMapper;
import org.skraua.yyzxbackend.pojo.Backdown;
import org.skraua.yyzxbackend.service.BackdownService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BackdownVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {

    @Autowired
    private BackdownMapper backdownMapper;

    @Override
    public ResultVo<Page<BackdownVo>> listPage(BackdownDTO backdownDTO) throws Exception {
        Page<BackdownVo> page = new Page<>(backdownDTO.getPageSize(), 6);
        backdownMapper.selectPageVo(page, backdownDTO.getUserId());
        return ResultVo.ok(page);
    }

}
