package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.vo.CustomerNurseItemVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/28
 * @description NurseContentMapper
 */
public interface NurseContentMapper extends BaseMapper<NurseContent> {

    // Page<NurseContentVo> selectPageVo(@Param("page") Page<> page,
    //         @Param("serialNumber") String serialNumber) throws Exception;
}