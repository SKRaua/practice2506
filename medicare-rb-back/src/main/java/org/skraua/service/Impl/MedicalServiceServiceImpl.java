package org.skraua.service.Impl;

import org.skraua.mapper.MedicalServiceMapper;
import org.skraua.pojo.MedicalService;
import org.skraua.service.MedicalServiceService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description MedicalServiceServiceImpl
 */
@Service
public class MedicalServiceServiceImpl extends ServiceImpl<MedicalServiceMapper, MedicalService> implements MedicalServiceService {
}