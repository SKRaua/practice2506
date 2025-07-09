// ReimbursementRatioServiceImpl.java
package org.skraua.service.Impl;

import org.skraua.dto.ReimbursementRatioDTO;
import org.skraua.mapper.ReimbursementRatioMapper;
import org.skraua.pojo.ReimbursementRatio;
import org.skraua.service.ReimbursementRatioService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.ReimbursementRatioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 报销比例维护Service实现类
 */
@Service
public class ReimbursementRatioServiceImpl extends ServiceImpl<ReimbursementRatioMapper, ReimbursementRatio>
        implements ReimbursementRatioService {

    @Autowired
    private ReimbursementRatioMapper ratioMapper;

    @Override
    public ResultVo<Page<ReimbursementRatioVo>> selectReimbursementRatioPage(ReimbursementRatioDTO ratioDTO)
            throws Exception {
        Page<ReimbursementRatioVo> page = new Page<>(ratioDTO.getPage(), 6);
        ratioMapper.selectReimbursementRatioPage(page, ratioDTO);
        return ResultVo.ok(page);
    }
}