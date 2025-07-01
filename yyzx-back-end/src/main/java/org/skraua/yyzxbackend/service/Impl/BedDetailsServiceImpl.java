package org.skraua.yyzxbackend.service.Impl;

import java.util.Date;

import org.skraua.yyzxbackend.dto.BedDetailsDTO;
import org.skraua.yyzxbackend.dto.ExchangeDTO;
import org.skraua.yyzxbackend.mapper.BedDetailsMapper;
import org.skraua.yyzxbackend.mapper.BedMapper;
import org.skraua.yyzxbackend.mapper.CustomerMapper;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.service.BedDetailsService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description
 */
@Service
public class BedDetailsServiceImpl extends ServiceImpl<BedDetailsMapper, BedDetails> implements BedDetailsService {
    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ResultVo<Page<BedDetailsVo>> listPage(BedDetailsDTO bedDetailsDTO) throws Exception {
        Page<BedDetailsVo> page = new Page<>(bedDetailsDTO.getPageSize(), 6);
        bedDetailsMapper.selectPageVo(page, bedDetailsDTO);
        return ResultVo.ok(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> exchangeBed(ExchangeDTO exchangeDTO) throws Exception {
        // 查询床位是否可用
        Bed bed = bedMapper.selectById(exchangeDTO.getNewBedId());
        if (bed.getBedStatus() != 1) {
            return ResultVo.fail("床位已占用");
        }
        // 修改旧床位详情信息：is_deleted = 1，设置床位结束日期
        BedDetails oldBedDetails = new BedDetails();
        oldBedDetails.setId(exchangeDTO.getOldBedId());
        oldBedDetails.setIsDeleted(1);
        oldBedDetails.setEndDate(new Date()); // 结束日期
        int update = bedDetailsMapper.updateById(oldBedDetails);
        // 添加新的床位记录的记录
        BedDetails newBedDetails = new BedDetails();
        newBedDetails.setCustomerId(exchangeDTO.getCustomerId());
        newBedDetails.setIsDeleted(0);
        newBedDetails.setBedId(exchangeDTO.getNewBedId());
        newBedDetails.setStartDate(new Date());
        newBedDetails.setEndDate(exchangeDTO.getEndDate());
        newBedDetails.setBedDetails(exchangeDTO.getNewBuilding() + "#" + bed.getBedNo());
        int insert = bedDetailsMapper.insert(newBedDetails);

        // 修改旧床位的状态为空闲 bed_status = 1
        Bed oldBed = new Bed();
        oldBed.setId(exchangeDTO.getOldBedId());
        oldBed.setBedStatus(1);
        int update1 = bedMapper.updateById(oldBed);
        // 修改新床位的状态为有人 bed_status = 2
        Bed newBed = new Bed();
        newBed.setId(exchangeDTO.getNewBedId());
        newBed.setBedStatus(2);
        int update2 = bedMapper.updateById(newBed);
        // 修改客户信息：房间号，新床位号，楼号
        Customer customer = new Customer();
        customer.setId(exchangeDTO.getCustomerId());
        customer.setRoomNo(exchangeDTO.getNewRoomNo());
        customer.setBedId(exchangeDTO.getNewBedId());
        customer.setBuildingNo(exchangeDTO.getNewBuilding());
        int update3 = customerMapper.updateById(customer);
        if (!(insert > 0 && update > 0 && update1 > 0 && update2 > 0 && update3 > 0)) {
            throw new Exception("修改失败");
        }
        return ResultVo.ok("修改成功");
    }
}