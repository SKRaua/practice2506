package org.skraua.service;

import org.skraua.dto.DrugDTO;
import org.skraua.pojo.Drug;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugService
 */
public interface DrugService extends IService<Drug> {
    ResultVo<Page<DrugVo>> selectDrugVoPage(DrugDTO drugDTO) throws Exception;
}