package org.skraua.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.pojo.Insureder;
import org.skraua.dto.InsurederDTO;
import org.skraua.vo.InsurederVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/07/08
 * @description PatientMapper
 */
public interface InsurederMapper extends BaseMapper<Insureder> {

    Page<InsurederVo> selectPatientPage(@Param("page") Page<InsurederVo> page,
            @Param("insurederDTO") InsurederDTO insurederDTO) throws Exception;
}
