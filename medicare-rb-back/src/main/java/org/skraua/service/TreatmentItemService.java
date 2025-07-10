package org.skraua.service;

import org.skraua.dto.TreatmentItemDTO;
import org.skraua.pojo.TreatmentItem;
import org.skraua.utils.ResultVo;
import org.skraua.vo.TreatmentItemVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description TreatmentItemService
 */
public interface TreatmentItemService extends IService<TreatmentItem> {
    ResultVo<Page<TreatmentItemVo>> selectTreatmentItemVoPage(TreatmentItemDTO dto) throws Exception;

    ResultVo<Void> addTreatmentItem(TreatmentItemDTO dto) throws Exception;

    ResultVo<Void> updateTreatmentItem(TreatmentItemDTO dto) throws Exception;

    ResultVo<Void> removeTreatmentItem(Integer id) throws Exception;
}