// DiagnosisServiceImpl.java
package org.skraua.service.Impl;

import org.skraua.mapper.DiagnosisMapper;
import org.skraua.pojo.Diagnosis;
import org.skraua.service.DiagnosisService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 诊断表Service实现类
 */
@Service
public class DiagnosisServiceImpl extends ServiceImpl<DiagnosisMapper, Diagnosis> implements DiagnosisService {
}