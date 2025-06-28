package org.skraua.yyzxbackend.service;

import java.util.List;

import org.skraua.yyzxbackend.dto.CustomerNurseItemDTO;
import org.skraua.yyzxbackend.pojo.CustomerNurseItem;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerNurseItemVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description
 */
public interface CustomerNurseItemService extends IService<CustomerNurseItem> {
    // 分页查询客户护理项目信息
    public ResultVo<Page<CustomerNurseItemVo>> listPage(CustomerNurseItemDTO customerNurseItemDTO)
            throws Exception;

    // 添加客户护理项目信息
    public ResultVo<Void> add(List<CustomerNurseItem> customerNurseItems) throws Exception;

    // 根据级别删除护理项目
    public ResultVo<Void> delLevelAndItem(Integer levelId, Integer customerId) throws Exception;

    // 删除客户护理项目信息
    public ResultVo<Void> delete(Integer id) throws Exception;

    // 用户是否已配置某个项目
    public ResultVo<Void> isIncludesItemCustomer(Integer customerId, Integer itemId) throws Exception;
}