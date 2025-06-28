package org.skraua.yyzxbackend.service.Impl;

import java.util.List;

import org.skraua.yyzxbackend.dto.CustomerNurseItemDTO;
import org.skraua.yyzxbackend.mapper.CustomerMapper;
import org.skraua.yyzxbackend.mapper.CustomerNurseItemMapper;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.pojo.CustomerNurseItem;
import org.skraua.yyzxbackend.service.CustomerNurseItemService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description
 */
@Service
public class CustomerNurseItemServiceImpl extends ServiceImpl<CustomerNurseItemMapper, CustomerNurseItem>
        implements CustomerNurseItemService {

    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ResultVo<Page<CustomerNurseItemVo>> listPage(CustomerNurseItemDTO customerNurseItemDTO) throws Exception {
        Page<CustomerNurseItemVo> page = new Page<>(customerNurseItemDTO.getPageSize(), 6);
        Integer customerId = customerNurseItemDTO.getCustomerId();
        customerNurseItemMapper.selectPageVo(page, customerId);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<Void> add(List<CustomerNurseItem> customerNurseItems) throws Exception {
        if (customerNurseItems.size() == 0) {
            return ResultVo.fail("请选择需要添加的护理项目");
        }
        // 判断是添加级别中护理项目，还是单独购买护理项目
        if (customerNurseItems.get(0).getLevelId() != null) {// 级别附带项目
            // 设置客户护理级别
            Customer customer = new Customer();
            customer.setId(customerNurseItems.get(0).getCustomerId());
            customer.setLevelId(customerNurseItems.get(0).getLevelId());
            int update = customerMapper.updateById(customer);
            if (update <= 0) {
                throw new Exception("添加失败");
            }
        }
        // 批量给用户添加护理项目
        boolean saveUpdate = saveBatch(customerNurseItems);
        if (!saveUpdate) {
            throw new Exception("添加失败");
        }
        return ResultVo.ok("护理项目配置成功");
    }

    @Override
    public ResultVo<Void> delLevelAndItem(Integer levelId, Integer customerId) throws Exception {
        // 更新护理级别为null
        UpdateWrapper<Customer> uw1 = new UpdateWrapper<>();
        uw1.set("level_id", null);
        uw1.eq("id", customerId);
        int update = customerMapper.update(null, uw1);

        // 删除客户当前级别的所有护理项目
        UpdateWrapper<CustomerNurseItem> uw2 = new UpdateWrapper<>();
        uw2.set("is_deleted", 1);
        uw2.eq("customer_id", customerId);
        uw2.eq("level_id", levelId);
        int update1 = customerNurseItemMapper.update(null, uw2);
        if (!(update1 > 0 && update > 0)) {
            throw new Exception("修改失败");
        }
        return ResultVo.ok("修改成功");
    }

    @Override
    public ResultVo<Void> delete(Integer id) throws Exception {
        CustomerNurseItem customerNurseItem = new CustomerNurseItem();
        customerNurseItem.setId(id);
        customerNurseItem.setIsDeleted(1);
        int update = customerNurseItemMapper.updateById(customerNurseItem);
        if (update <= 0) {
            throw new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }

    @Override
    public ResultVo<Void> isIncludesItemCustomer(Integer customerId, Integer itemId) throws Exception {
        QueryWrapper<CustomerNurseItem> qw = new QueryWrapper<>();
        qw.eq("customer_id", customerId);
        qw.eq("item_id", itemId);
        qw.eq("", qw);
        int count = customerNurseItemMapper.selectCount(qw);
        if (count > 0) {
            return ResultVo.fail("客户未配置该项目");
        }
        return ResultVo.ok("客户已配置该项目");
    }

}
