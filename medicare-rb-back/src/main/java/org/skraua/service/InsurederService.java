package org.skraua.service;

import java.util.List;

import org.skraua.dto.InsurederDTO;
import org.skraua.pojo.Insureder;
import org.skraua.utils.ResultVo;
import org.skraua.vo.InsurederVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/08
 * @description
 */
public interface InsurederService extends IService<Insureder> {

    public ResultVo<Page<InsurederVo>> selectInsurederPage(InsurederDTO patientDTO) throws Exception;

    public ResultVo<Void> addInsurederInfo(InsurederDTO patientDTO) throws Exception;

    public ResultVo<Void> editInsurederInfo(InsurederDTO patientDTO) throws Exception;

}
