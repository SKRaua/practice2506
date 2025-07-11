// DiseaseService.java
package org.skraua.service;

import org.skraua.dto.DiseaseDTO;
import org.skraua.pojo.Disease;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DiseaseVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 疾病维护表Service
 */
public interface DiseaseService extends IService<Disease> {
    ResultVo<Page<DiseaseVo>> selectDiseaseVoPage(DiseaseDTO diseaseDTO) throws Exception;

    ResultVo<Void> addDisease(Disease disease);

    ResultVo<Void> updateDisease(Disease disease);

    ResultVo<Void> deleteDisease(Integer id);
}