package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.TreatmentItemDTO;
import org.skraua.pojo.TreatmentItem;
import org.skraua.vo.TreatmentItemVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description TreatmentItemMapper
 */
public interface TreatmentItemMapper extends BaseMapper<TreatmentItem> {
    Page<TreatmentItemVo> selectTreatmentItemVoPage(Page<TreatmentItemVo> page,
            @Param("treatmentItemDTO") TreatmentItemDTO dto);
}