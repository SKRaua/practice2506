package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.CustomerInfoDTO;
import org.skraua.yyzxbackend.mapper.BedDetailsMapper;
import org.skraua.yyzxbackend.mapper.BedMapper;
import org.skraua.yyzxbackend.mapper.CustomerMapper;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.service.CustomerService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/26
 * @description
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private BedDetailsMapper bedDetailsMapper;

    @Autowired
    private BedMapper bedMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> add(Customer customer) throws Exception {
        // 查询床位是否可用
        Bed bed = bedMapper.selectById(customer.getBedId());
        if (bed.getBedStatus() != 1) {
            return ResultVo.fail("床位已占用");
        }

        // 生成客户信息
        customer.setIsDeleted(0);
        customer.setUserId(-1);// 默认无管家
        int insert1 = customerMapper.insert(customer);

        // 生成入住详情信息
        BedDetails bedDetails = new BedDetails();
        bedDetails.setBedId(customer.getBedId());
        bedDetails.setStartDate(customer.getCheckinDate());
        bedDetails.setEndDate(customer.getExpirationDate());
        bedDetails.setBedDetails(customer.getBuildingNo() + "#" + bed.getBedNo());
        bedDetails.setCustomerId(customer.getId());
        bedDetails.setIsDeleted(0);// 床位生效
        int insert2 = bedDetailsMapper.insert(bedDetails);

        // 修改床位状态
        Bed bedUpdate = new Bed();
        bedUpdate.setId(bed.getId());
        bedUpdate.setBedStatus(2);
        int update3 = bedMapper.updateById(bedUpdate);

        // 判断是否入住成功
        if (!(insert1 > 0 && insert2 > 0 && update3 > 0)) {
            throw new Exception("入住失败");
        }
        return ResultVo.ok("入住成功");
    }

    @Override
    public ResultVo<Page<CustomerInfoVo>> listCustomerInfoPage(CustomerInfoDTO customerInfoDTO) throws Exception {
        Page<CustomerInfoVo> page = new Page<>(customerInfoDTO.getPageSize(), 6);
        String customerName = customerInfoDTO.getCustomerName();
        Integer userId = customerInfoDTO.getUserId();
        Integer manType = customerInfoDTO.getManType();
        customerMapper.selectPageVo(page, customerName, manType, userId);
        return ResultVo.ok(page);
    }

    // 根据逻辑，此处应当为标记删除，而并非在数据库进行移除记录，固修改方法名
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> delete(Integer id, Integer bedId) throws Exception {
        // 删除客户
        Customer customer = new Customer();
        customer.setId(id);
        customer.setIsDeleted(1);
        int update = customerMapper.updateById(customer);

        // 床位空闲
        Bed bed = new Bed();
        bed.setId(bedId);
        bed.setBedStatus(1);
        int update1 = bedMapper.updateById(bed);

        // 修改床位状态
        BedDetails bedDetails = new BedDetails();
        bedDetails.setIsDeleted(1);// 床位失效
        UpdateWrapper<BedDetails> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("customer_id", id);
        updateWrapper.eq("bed_id", bedId);
        updateWrapper.eq("is_deleted", 0);
        int update2 = bedDetailsMapper.update(bedDetails, updateWrapper);

        // 判断是否删除成功
        if (!(update > 0 && update1 > 0 && update2 > 0)) {
            throw new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> update(Customer customer) throws Exception {
        int update = customerMapper.updateById(customer);
        if (update <= 0) {
            throw new Exception("修改失败");
        }
        // 如果修改了合同到期时间，需要同步修改床位详情的到期时间
        if (customer.getExpirationDate() != null) {
            UpdateWrapper<BedDetails> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("customer_id", customer.getId());
            updateWrapper.eq("is_deleted", 0);
            BedDetails bedDetails = new BedDetails();
            bedDetails.setEndDate(customer.getExpirationDate());
            int update1 = bedDetailsMapper.update(bedDetails, updateWrapper);
            if (update1 <= 0) {
                throw new Exception("修改失败");
            }
        }
        return ResultVo.ok("修改成功");
    }

}
