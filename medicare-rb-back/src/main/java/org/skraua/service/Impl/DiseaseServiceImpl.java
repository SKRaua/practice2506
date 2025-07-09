// DiseaseServiceImpl.java
package org.skraua.service.Impl;

import org.skraua.mapper.DiseaseMapper;
import org.skraua.pojo.Disease;
import org.skraua.service.DiseaseService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 疾病维护表Service实现类
 */
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {
}