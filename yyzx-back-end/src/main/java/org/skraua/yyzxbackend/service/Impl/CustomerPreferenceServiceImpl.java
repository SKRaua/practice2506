package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.CustomerPreferenceDTO;
import org.skraua.yyzxbackend.mapper.CustomerPreferenceMapper;
import org.skraua.yyzxbackend.pojo.CustomerPreference;
import org.skraua.yyzxbackend.service.CustomerPreferenceService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerPreferenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description
 */
@Service
public class CustomerPreferenceServiceImpl extends ServiceImpl<CustomerPreferenceMapper, CustomerPreference>
        implements CustomerPreferenceService {

    @Autowired
    private CustomerPreferenceMapper customerPreferenceMapper;

    @Override
    public ResultVo<Page<CustomerPreferenceVo>> listPage(CustomerPreferenceDTO customerPreferenceDTO) throws Exception {
        Page<CustomerPreferenceVo> page = new Page<>(customerPreferenceDTO.getPageSize(), 6);
        String customerName = customerPreferenceDTO.getCustomerName();
        customerPreferenceMapper.selectPageVo(page, customerName);
        return ResultVo.ok(page);
    }

}
