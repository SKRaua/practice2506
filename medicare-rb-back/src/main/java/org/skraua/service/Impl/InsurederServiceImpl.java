package org.skraua.service.Impl;

import org.skraua.dto.InsurederDTO;
import org.skraua.mapper.HospitalizationMapper;
import org.skraua.mapper.InsurederMapper;
import org.skraua.mapper.RoleMapper;
import org.skraua.pojo.Hospitalization;
import org.skraua.pojo.Insureder;
import org.skraua.pojo.Role;
import org.skraua.service.InsurederService;
import org.skraua.service.RoleService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.InsurederVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.swagger.models.auth.In;

/**
 * @author Zhou Xinyang
 * @date 2025/07/08
 * @description
 */
@Service
public class InsurederServiceImpl extends ServiceImpl<InsurederMapper, Insureder> implements InsurederService {

    @Autowired
    private InsurederMapper insurederMapper;

    @Autowired
    private HospitalizationMapper hospitalizationMapper;

    @Override
    public ResultVo<Page<InsurederVo>> selectInsurederPage(InsurederDTO patientDTO) throws Exception {
        Page<InsurederVo> page = new Page<>(patientDTO.getPage(), 6);
        insurederMapper.selectPatientPage(page, patientDTO);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<Void> addInsurederInfo(InsurederDTO patientDTO) throws Exception {
        Insureder insureder = new Insureder();
        Hospitalization hospitalization = new Hospitalization();
        BeanUtils.copyProperties(patientDTO, insureder);
        BeanUtils.copyProperties(patientDTO, hospitalization);
        int save = insurederMapper.insert(insureder);
        int save1 = hospitalizationMapper.insert(hospitalization);
        if (save > 0 && save1 > 0) {
            return ResultVo.ok("添加成功");
        }
        throw new Exception("添加失败");
    }

    @Override
    public ResultVo<Void> editInsurederInfo(InsurederDTO patientDTO) throws Exception {
        Insureder insureder = new Insureder();
        Hospitalization hospitalization = new Hospitalization();
        BeanUtils.copyProperties(patientDTO, insureder);
        BeanUtils.copyProperties(patientDTO, hospitalization);
        int save = insurederMapper.updateById(insureder);
        int save1 = hospitalizationMapper.updateById(hospitalization);
        if (save > 0 && save1 > 0) {
            return ResultVo.ok("添加成功");
        }
        throw new Exception("添加失败");
    }

    // @Override
    // public ResultVo<Void> removeInsurederInfo(InsurederDTO patientDTO) throws Exception {
    //     Insureder insureder = new Insureder();
    //     Hospitalization hospitalization = new Hospitalization();
    //     BeanUtils.copyProperties(patientDTO, insureder);
    //     BeanUtils.copyProperties(patientDTO, hospitalization);
    //     int save = insurederMapper.updateById(insureder);
    //     int save1 = hospitalizationMapper.updateById(hospitalization);
    //     if (save > 0 && save1 > 0) {
    //         return ResultVo.ok("添加成功");
    //     }
    //     throw new Exception("添加失败");
    // }

}
