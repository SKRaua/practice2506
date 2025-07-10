package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.MedicalServiceDTO;
import org.skraua.pojo.MedicalService;
import org.skraua.vo.MedicalServiceVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description MedicalServiceMapper
 */
public interface MedicalServiceMapper extends BaseMapper<MedicalService> {
    Page<MedicalServiceVo> selectMedicalServiceVoPage(Page<MedicalServiceVo> page,
            @Param("medicalServiceDTO") MedicalServiceDTO dto);
}