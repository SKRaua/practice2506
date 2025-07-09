// ReimbursementRatioService.java
package org.skraua.service;

import org.skraua.dto.ReimbursementRatioDTO;
import org.skraua.pojo.ReimbursementRatio;
import org.skraua.utils.ResultVo;
import org.skraua.vo.ReimbursementRatioVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 报销比例维护Service
 */
public interface ReimbursementRatioService extends IService<ReimbursementRatio> {
    public ResultVo<Page<ReimbursementRatioVo>> selectReimbursementRatioPage(ReimbursementRatioDTO ratioDTO)
            throws Exception;

}