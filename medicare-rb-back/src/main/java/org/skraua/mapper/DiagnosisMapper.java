// DiagnosisMapper.java
package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.DiagnosisDTO;
import org.skraua.pojo.Diagnosis;
import org.skraua.vo.DiagnosisVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 诊断表Mapper
 */
public interface DiagnosisMapper extends BaseMapper<Diagnosis> {
    Page<DiagnosisVo> selectDiagnosisVoPage(Page<DiagnosisVo> page, @Param("diagnosisDTO") DiagnosisDTO diagnosisDTO);
}