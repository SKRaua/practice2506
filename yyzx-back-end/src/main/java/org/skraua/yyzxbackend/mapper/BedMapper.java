package org.skraua.yyzxbackend.mapper;

import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.vo.BedUsageVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Zhou Xinyang
 * @date 2025/06/24
 * @description BedMapper
 */
public interface BedMapper extends BaseMapper<Bed> {
    BedUsageVo selectBedCount();
}