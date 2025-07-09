package org.skraua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.skraua.dto.TreatmentItemOrderDTO;
import org.skraua.pojo.TreatmentItemOrder;
import org.skraua.vo.TreatmentItemOrderVo;

/**
 * @author Zhou Xinyang
 * @date 2025/07/10
 * @description TreatmentItemOrderMapper
 */
public interface TreatmentItemOrderMapper extends BaseMapper<TreatmentItemOrder> {

        Page<TreatmentItemOrderVo> selectTreatmentItemOrderVoPage(Page<TreatmentItemOrderVo> page,
                        @Param("treatmentItemOrderDTO") TreatmentItemOrderDTO treatmentItemOrderDTO);

}