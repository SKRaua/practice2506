package org.skraua.service.Impl;

import org.skraua.dto.DrugOrderDTO;
import org.skraua.mapper.DrugOrderMapper;
import org.skraua.pojo.DrugOrder;
import org.skraua.service.DrugOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugOrder的Service实现类
 */
@Service
public class DrugOrderServiceImpl extends ServiceImpl<DrugOrderMapper, DrugOrder> implements DrugOrderService {

    @Autowired
    private DrugOrderMapper drugOrderMapper;

    @Override
    public ResultVo<Page<DrugOrderVo>> selectDrugOrderVoPage(DrugOrderDTO drugOrderDTO) throws Exception {
        Page<DrugOrderVo> page = new Page<>(drugOrderDTO.getPage(), 6);
        drugOrderMapper.selectDrugOrderVoPage(page, drugOrderDTO);
        return ResultVo.ok(page);
    }
}