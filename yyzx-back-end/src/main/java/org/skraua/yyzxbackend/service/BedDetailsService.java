package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.BedDetailsDTO;
import org.skraua.yyzxbackend.dto.ExchangeDTO;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedDetailsVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/24
 * @description
 */
public interface BedDetailsService extends IService<BedDetails> {
    // 返回一个分页查询的视图
    ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) throws Exception;

    // 交换床位
    ResultVo<Void> exchangeBed(ExchangeDTO exchangeDTO) throws Exception;
}
