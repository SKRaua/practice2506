// DiagnosisService.java
package org.skraua.service;

import org.skraua.dto.DiagnosisDTO;
import org.skraua.pojo.Diagnosis;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DiagnosisVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 诊断表Service
 */
public interface DiagnosisService extends IService<Diagnosis> {
    ResultVo<Page<DiagnosisVo>> selectDiagnosisVoPage(DiagnosisDTO diagnosisDTO) throws Exception;

    ResultVo<Void> addDiagnosis(DiagnosisDTO diagnosisDTO) throws Exception;

    ResultVo<Void> updateDiagnosis(DiagnosisDTO diagnosisDTO) throws Exception;

    ResultVo<Void> removeDiagnosis(Integer id) throws Exception;
}