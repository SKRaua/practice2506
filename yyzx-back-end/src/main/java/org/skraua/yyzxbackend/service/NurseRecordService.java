package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.NurseRecordDTO;
import org.skraua.yyzxbackend.pojo.NurseRecord;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.NurseRecordVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
public interface NurseRecordService extends IService<NurseRecord> {
    public ResultVo<Void> add(NurseRecord nurseRecord) throws Exception;

    public ResultVo<Page<NurseRecordVo>> listPage(NurseRecordDTO nurseRecordDTO) throws Exception;
}
