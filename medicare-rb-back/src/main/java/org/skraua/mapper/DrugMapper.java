package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.DrugDTO;
import org.skraua.pojo.Drug;
import org.skraua.vo.DrugVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugMapper
 */
public interface DrugMapper extends BaseMapper<Drug> {
    Page<DrugVo> selectDrugVoPage(Page<DrugVo> page, @Param("drugDTO") DrugDTO drugDTO);
}