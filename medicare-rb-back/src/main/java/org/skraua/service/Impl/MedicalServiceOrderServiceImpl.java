package org.skraua.service.Impl;

import org.skraua.dto.MedicalServiceOrderDTO;
import org.skraua.mapper.MedicalServiceOrderMapper;
import org.skraua.pojo.MedicalServiceOrder;
import org.skraua.service.MedicalServiceOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.MedicalServiceOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 医疗记录Service实现类
 */
@Service
public class MedicalServiceOrderServiceImpl extends ServiceImpl<MedicalServiceOrderMapper, MedicalServiceOrder>
        implements MedicalServiceOrderService {

    @Autowired
    private MedicalServiceOrderMapper medicalServiceOrderMapper;

    @Override
    public ResultVo<Page<MedicalServiceOrderVo>> selectMedicalServiceOrderVoPage(
            MedicalServiceOrderDTO medicalServiceOrderDTO) throws Exception {
        Page<MedicalServiceOrderVo> page = new Page<>(medicalServiceOrderDTO.getPage(), 6);
        medicalServiceOrderMapper.selectMedicalServiceOrderVoPage(page, medicalServiceOrderDTO);
        return ResultVo.ok(page);
    }
}