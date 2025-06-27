package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.CustomerPreferenceDTO;
import org.skraua.yyzxbackend.pojo.CustomerPreference;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerPreferenceVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description
 */
public interface CustomerPreferenceService extends IService<CustomerPreference> {
    // 分页查询客户喜好信息
    public ResultVo<Page<CustomerPreferenceVo>> listPage(CustomerPreferenceDTO customerPreferenceDTO)
            throws Exception;
}
