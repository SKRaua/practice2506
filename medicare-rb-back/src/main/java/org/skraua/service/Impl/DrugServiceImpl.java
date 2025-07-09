package org.skraua.service.Impl;

import org.skraua.mapper.DrugMapper;
import org.skraua.pojo.Drug;
import org.skraua.service.DrugService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugServiceImpl
 */
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
}