package org.skraua.service;

import org.skraua.dto.MedicalServiceDTO;
import org.skraua.pojo.MedicalService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.MedicalServiceVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description MedicalServiceService
 */
public interface MedicalServiceService extends IService<MedicalService> {

    ResultVo<Page<MedicalServiceVo>> selectMedicalServiceVoPage(MedicalServiceDTO dto) throws Exception;

    ResultVo<Void> addMedicalService(MedicalServiceDTO dto) throws Exception;

    ResultVo<Void> updateMedicalService(MedicalServiceDTO dto) throws Exception;

    ResultVo<Void> removeMedicalService(Integer id) throws Exception;

}