package org.skraua.service.Impl;

import org.skraua.mapper.TreatmentItemMapper;
import org.skraua.pojo.TreatmentItem;
import org.skraua.service.TreatmentItemService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description TreatmentItemServiceImpl
 */
@Service
public class TreatmentItemServiceImpl extends ServiceImpl<TreatmentItemMapper, TreatmentItem>
        implements TreatmentItemService {
}