package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.OutwardDTO;
import org.skraua.yyzxbackend.pojo.Outward;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.OutwardVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
public interface OutwardService extends IService<Outward> {
    // 分页查询
    ResultVo<Page<OutwardVo>> listPage(OutwardDTO outwardDTO) throws Exception;

    // 审批外出
    ResultVo<Void> examineOutward(Outward outward) throws Exception;

    // 撤销外出登记
    ResultVo<Void> delOutward(Outward outward) throws Exception;

    // 登记回院时间
    ResultVo<Void> updateBackTime(Outward outward) throws Exception;
}
