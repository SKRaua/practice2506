// ReimbursementRatioMapper.java
package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.dto.InsurederDTO;
import org.skraua.dto.ReimbursementRatioDTO;
import org.skraua.pojo.ReimbursementRatio;
import org.skraua.vo.InsurederVo;
import org.skraua.vo.ReimbursementRatioVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 报销比例维护Mapper
 */
public interface ReimbursementRatioMapper extends BaseMapper<ReimbursementRatio> {

    Page<InsurederVo> selectReimbursementRatioPage(@Param("page") Page<ReimbursementRatioVo> page,
            @Param("ratioDTO") ReimbursementRatioDTO ratioDTO) throws Exception;
}