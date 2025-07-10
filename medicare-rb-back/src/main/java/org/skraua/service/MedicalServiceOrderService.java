// MedicalOrderService.java
package org.skraua.service;

import org.skraua.dto.MedicalServiceOrderDTO;
import org.skraua.pojo.MedicalServiceOrder;
import org.skraua.utils.ResultVo;
import org.skraua.vo.MedicalServiceOrderVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 医疗记录Service
 */
public interface MedicalServiceOrderService extends IService<MedicalServiceOrder> {

    public ResultVo<Page<MedicalServiceOrderVo>> selectMedicalServiceOrderVoPage(
            MedicalServiceOrderDTO medicalServiceOrderDTO) throws Exception;

    ResultVo<Void> addMedicalServiceOrder(MedicalServiceOrderDTO dto) throws Exception;

    ResultVo<Void> updateMedicalServiceOrder(MedicalServiceOrderDTO dto) throws Exception;

    ResultVo<Void> removeMedicalServiceOrder(Integer id) throws Exception;

}