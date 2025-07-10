package org.skraua.service.Impl;

import org.skraua.dto.MedicalServiceDTO;
import org.skraua.mapper.MedicalServiceMapper;
import org.skraua.pojo.MedicalService;
import org.skraua.service.MedicalServiceService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.MedicalServiceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description MedicalServiceServiceImpl
 */
@Service
public class MedicalServiceServiceImpl extends ServiceImpl<MedicalServiceMapper, MedicalService>
        implements MedicalServiceService {
    @Autowired
    private MedicalServiceMapper medicalServiceMapper;

    @Override
    public ResultVo<Page<MedicalServiceVo>> selectMedicalServiceVoPage(MedicalServiceDTO dto) throws Exception {
        Page<MedicalServiceVo> page = new Page<>(dto.getPage(), 6);
        medicalServiceMapper.selectMedicalServiceVoPage(page, dto);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<Void> addMedicalService(MedicalServiceDTO dto) throws Exception {
        MedicalService service = new MedicalService();
        BeanUtils.copyProperties(dto, service);
        int res = medicalServiceMapper.insert(service);
        return res > 0 ? ResultVo.ok("添加成功") : ResultVo.fail("添加失败");
    }

    @Override
    public ResultVo<Void> updateMedicalService(MedicalServiceDTO dto) throws Exception {
        MedicalService service = new MedicalService();
        BeanUtils.copyProperties(dto, service);
        int res = medicalServiceMapper.updateById(service);
        return res > 0 ? ResultVo.ok("修改成功") : ResultVo.fail("修改失败");
    }

    @Override
    public ResultVo<Void> removeMedicalService(Integer id) throws Exception {
        int res = medicalServiceMapper.deleteById(id);
        return res > 0 ? ResultVo.ok("删除成功") : ResultVo.fail("删除失败");
    }
}