// ReimbursementRecordService.java
package org.skraua.service;

import org.skraua.dto.ReimbursementCalcDTO;
import org.skraua.dto.ReimbursementRecordDTO;
import org.skraua.pojo.ReimbursementRecord;
import org.skraua.utils.ResultVo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 报销记录Service
 */
public interface ReimbursementRecordService extends IService<ReimbursementRecord> {
    // 计算费用并返回DTO
    public ResultVo<ReimbursementCalcDTO> calculateReimbursement(Integer insurederId) throws Exception;

    // 确认报销并保存记录
    public ResultVo<Void> confirmReimbursement(ReimbursementRecordDTO recordDTO) throws Exception;
}