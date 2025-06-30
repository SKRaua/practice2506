package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.Outward;
import org.skraua.yyzxbackend.vo.OutwardVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description OutwardMapper
 */
public interface OutwardMapper extends BaseMapper<Outward> {
    Page<OutwardVo> selectOutwardPage(@Param("page") Page<OutwardVo> page,
            @Param("userId") Integer userId) throws Exception;
}
