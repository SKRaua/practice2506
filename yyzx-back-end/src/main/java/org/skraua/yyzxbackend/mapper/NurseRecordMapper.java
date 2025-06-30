package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.NurseRecord;
import org.skraua.yyzxbackend.vo.NurseRecordVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description NurseRecordMapper
 */
public interface NurseRecordMapper extends BaseMapper<NurseRecord> {
    Page<NurseRecordVo> selectPageVo(@Param("page") Page<NurseRecordVo> page,
            @Param("customerId") Integer customerId) throws Exception;
}