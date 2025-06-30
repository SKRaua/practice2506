package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.dto.BedDetailsDTO;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.vo.BedDetailsVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/24
 * @description
 */
public interface BedDetailsMapper extends BaseMapper<BedDetails> {
    // 分页查询
    Page<BedDetailsVo> selectPageVo(@Param("page") Page<BedDetailsVo> page,
            @Param("bedDetailsDTO") BedDetailsDTO bedDetailsDTO);
}
