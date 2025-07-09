package org.skraua.service.Impl;

import org.skraua.dto.TreatmentItemOrderDTO;
import org.skraua.mapper.TreatmentItemOrderMapper;
import org.skraua.pojo.TreatmentItemOrder;
import org.skraua.service.TreatmentItemOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.TreatmentItemOrderVo;
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
public class TreatmentItemOrderServiceImpl extends ServiceImpl<TreatmentItemOrderMapper, TreatmentItemOrder>
        implements TreatmentItemOrderService {

    @Autowired
    private TreatmentItemOrderMapper treatmentItemOrderMapper;

    @Override
    public ResultVo<Page<TreatmentItemOrderVo>> selectTreatmentItemOrderVoPage(
            TreatmentItemOrderDTO treatmentItemOrderDTO) throws Exception {
        Page<TreatmentItemOrderVo> page = new Page<>(treatmentItemOrderDTO.getPage(), 6);
        treatmentItemOrderMapper.selectTreatmentItemOrderVoPage(page, treatmentItemOrderDTO);
        return ResultVo.ok(page);
    }
}