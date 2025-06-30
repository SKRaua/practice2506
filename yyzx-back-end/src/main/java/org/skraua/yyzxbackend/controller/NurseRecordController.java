package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.NurseRecordDTO;
import org.skraua.yyzxbackend.dto.OutwardDTO;
import org.skraua.yyzxbackend.pojo.NurseRecord;
import org.skraua.yyzxbackend.service.NurseRecordService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.NurseRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@RestController
@RequestMapping("/nurseRecord")
@Api(tags = "护理记录")
@CrossOrigin
public class NurseRecordController {

    @Autowired
    private NurseRecordService nurseRecordService;

    @GetMapping("/listPage")
    @ApiOperation("分页查询 根据客户id")
    public ResultVo<Page<NurseRecordVo>> listPage(NurseRecordDTO nurseRecordDTO) throws Exception {
        return nurseRecordService.listPage(nurseRecordDTO);
    }

    @PostMapping("/add")
    @ApiOperation("添加护理记录")
    public ResultVo<Void> add(NurseRecord nurseRecord) throws Exception {
        return nurseRecordService.add(nurseRecord);
    }

    @PostMapping("/delete")
    @ApiOperation("删除护理记录")
    public ResultVo<Void> delete(Integer id) throws Exception {
        // TODO 考虑转移逻辑到service层
        NurseRecord nurseRecord = new NurseRecord();
        nurseRecord.setId(id);
        nurseRecord.setIsDeleted(1);
        nurseRecordService.updateById(nurseRecord);
        return ResultVo.ok("删除成功");
    }

    @GetMapping("/queryOutwardVo")
    @ApiOperation("查询外出记录")
    public ResultVo<Void> queryOutwardVo(OutwardDTO outwardDTO) throws Exception {
        // TODO ...
        throw new UnsupportedOperationException("Unimplemented method 'queryOutwardVo'");
        // return outwardService.queryOutwardVo(outwardDTO);
    }

}
