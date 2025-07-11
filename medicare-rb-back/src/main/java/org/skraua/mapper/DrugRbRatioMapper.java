package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.DrugRbRatioDTO;
import org.skraua.pojo.DrugRbRatio;
import org.skraua.vo.DrugRbRatioVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 药品报销比例维护Mapper
 */
public interface DrugRbRatioMapper extends BaseMapper<DrugRbRatio> {
    Page<DrugRbRatioVo> selectDrugRbRatioVoPage(Page<DrugRbRatioVo> page, @Param("dto") DrugRbRatioDTO dto);
}