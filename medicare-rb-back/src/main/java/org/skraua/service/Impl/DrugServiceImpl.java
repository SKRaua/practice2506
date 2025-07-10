package org.skraua.service.Impl;

import org.skraua.dto.DrugDTO;
import org.skraua.mapper.DrugMapper;
import org.skraua.pojo.Drug;
import org.skraua.service.DrugService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugServiceImpl
 */
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public ResultVo<Page<DrugVo>> selectDrugVoPage(DrugDTO drugDTO) throws Exception {
        Page<DrugVo> page = new Page<>(drugDTO.getPage(), 6);
        drugMapper.selectDrugVoPage(page, drugDTO);
        return ResultVo.ok(page);
    }
}