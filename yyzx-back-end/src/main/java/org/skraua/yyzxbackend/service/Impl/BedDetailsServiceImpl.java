package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.BedDetailsDTO;
import org.skraua.yyzxbackend.dto.ExchangeDTO;
import org.skraua.yyzxbackend.mapper.BedDetailsMapper;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.service.BedDetailsService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/24
 * @description
 */
@Service
public class BedDetailsServiceImpl extends ServiceImpl<BedDetailsMapper, BedDetails> implements BedDetailsService {
    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Override
    public ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) {
        Page<BedDetailsVo> page = new Page<>(bedDetailsDTO.getPageSize(), 6);
        bedDetailsMapper.selectBedDetailsVo(page, bedDetailsDTO);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<Void> exchangeBed(ExchangeDTO exchangeDTO) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exchangeBed'");
    }

}
