// DrugRbRatioService.java
package org.skraua.service;

import java.util.List;

import org.skraua.dto.DrugRbRatioDTO;
import org.skraua.pojo.DrugRbRatio;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugRbRatioVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 药品报销比例维护Service
 */
public interface DrugRbRatioService extends IService<DrugRbRatio> {
    ResultVo<Page<DrugRbRatioVo>> selectDrugRbRatioVoPage(DrugRbRatioDTO dto) throws Exception;

    List<DrugRbRatioVo> getEnabledDrugRbRatios();

    ResultVo<Void> addDrugRbRatio(DrugRbRatioDTO dto) throws Exception;

    ResultVo<Void> updateDrugRbRatio(DrugRbRatioDTO dto) throws Exception;

    ResultVo<Void> removeDrugRbRatio(Integer id) throws Exception;
}