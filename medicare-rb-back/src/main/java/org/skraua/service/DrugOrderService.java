package org.skraua.service;

import org.skraua.dto.DrugOrderDTO;
import org.skraua.pojo.DrugOrder;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugOrderVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugOrder的Service接口
 */
public interface DrugOrderService extends IService<DrugOrder> {

    public ResultVo<Page<DrugOrderVo>> selectDrugOrderVoPage(DrugOrderDTO drugOrderDTO) throws Exception;

    ResultVo<Void> addDrugOrder(DrugOrderDTO drugOrderDTO) throws Exception;

    ResultVo<Void> updateDrugOrder(DrugOrderDTO drugOrderDTO) throws Exception;

    ResultVo<Void> removeDrugOrder(Integer id) throws Exception;

}