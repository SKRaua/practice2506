package org.skraua.service.Impl;

import org.skraua.dto.DrugDTO;
import org.skraua.mapper.DrugMapper;
import org.skraua.pojo.Drug;
import org.skraua.service.DrugService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description DrugServiceImpl
 */
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public ResultVo<Page<DrugVo>> selectDrugVoPage(DrugDTO drugDTO) throws Exception {
        Page<DrugVo> page = new Page<>(drugDTO.getPage(), 6);
        drugMapper.selectDrugVoPage(page, drugDTO);
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<Void> addDrug(DrugDTO dto) throws Exception {
        Drug drug = new Drug();
        BeanUtils.copyProperties(dto, drug);
        int res = drugMapper.insert(drug);
        return res > 0 ? ResultVo.ok("添加成功") : ResultVo.fail("添加失败");
    }

    @Override
    public ResultVo<Void> updateDrug(DrugDTO dto) throws Exception {
        Drug drug = new Drug();
        BeanUtils.copyProperties(dto, drug);
        int res = drugMapper.updateById(drug);
        return res > 0 ? ResultVo.ok("修改成功") : ResultVo.fail("修改失败");
    }

    @Override
    public ResultVo<Void> removeDrug(Integer id) throws Exception {
        int res = drugMapper.deleteById(id);
        return res > 0 ? ResultVo.ok("删除成功") : ResultVo.fail("删除失败");
    }
}