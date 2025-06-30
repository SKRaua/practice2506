package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.BackdownDTO;
import org.skraua.yyzxbackend.mapper.BackdownMapper;
import org.skraua.yyzxbackend.pojo.Backdown;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.service.BackdownService;
import org.skraua.yyzxbackend.service.BedService;
import org.skraua.yyzxbackend.service.CustomerService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BackdownVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {

    @Autowired
    private BackdownMapper backdownMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BedService bedService;

    @Override
    public ResultVo<Page<BackdownVo>> listPage(BackdownDTO backdownDTO) throws Exception {
        Page<BackdownVo> page = new Page<>(backdownDTO.getPageSize(), 6);
        backdownMapper.selectPageVo(page, backdownDTO.getUserId());
        return ResultVo.ok(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> examineBackdown(Backdown backdown) throws Exception {
        // 更新审批
        int update = backdownMapper.updateById(backdown);
        if (update <= 0) {
            throw new Exception("更新失败");
        }
        // 审批通过，修改床铺记录为空闲
        Backdown backdownInbd = getById(backdown.getId());
        if (backdown.getAuditstatus() == 1) {
            Customer customer = customerService.getById(backdownInbd.getCustomerId());
            Bed bed = new Bed();
            bed.setId(customer.getBedId());
            bed.setBedStatus(1);
            boolean update1 = bedService.updateById(bed);
            if (!update1) {
                throw new Exception("更新失败");
            }
        }
        return ResultVo.ok("审核退住成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> delete(Integer id) throws Exception {
        Backdown backdown = new Backdown();
        backdown.setId(id);
        backdown.setIsDeleted(1);
        boolean update = updateById(backdown);
        if (!update) {
            throw new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }

}
