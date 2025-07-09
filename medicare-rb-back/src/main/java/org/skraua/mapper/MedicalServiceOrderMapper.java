package org.skraua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.skraua.dto.MedicalServiceOrderDTO;
import org.skraua.pojo.MedicalServiceOrder;
import org.skraua.vo.MedicalServiceOrderVo;

/**
 * @author Zhou Xinyang
 * @date 2025/07/01
 * @description MedicalOrderMapper
 */
public interface MedicalServiceOrderMapper extends BaseMapper<MedicalServiceOrder> {

        /**
         * 按投保人/病人的id和orderType分页查询MedicalServiceVo
         * 
         * @param page      分页参数
         * @param id        投保人/病人的id
         * @param orderType 订单类型
         * @return 分页结果
         */
        Page<MedicalServiceOrderVo> selectMedicalServiceOrderVoPage(Page<MedicalServiceOrderVo> page,
                        @Param("medicalServiceOrderDTO") MedicalServiceOrderDTO medicalServiceOrderDTO);

}