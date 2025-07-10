package org.skraua.service;

import org.skraua.dto.TreatmentItemOrderDTO;
import org.skraua.pojo.TreatmentItemOrder;
import org.skraua.utils.ResultVo;
import org.skraua.vo.TreatmentItemOrderVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description TreatmentItemOrderService
 */
public interface TreatmentItemOrderService extends IService<TreatmentItemOrder> {
    public ResultVo<Page<TreatmentItemOrderVo>> selectTreatmentItemOrderVoPage(
            TreatmentItemOrderDTO treatmentItemOrderDTO) throws Exception;

    ResultVo<Void> addTreatmentItemOrder(TreatmentItemOrderDTO dto) throws Exception;

    ResultVo<Void> updateTreatmentItemOrder(TreatmentItemOrderDTO dto) throws Exception;

    ResultVo<Void> removeTreatmentItemOrder(Integer id) throws Exception;
}