package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.pojo.Room;
import org.skraua.yyzxbackend.service.RoomService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedUsageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description
 */
@RestController
@RequestMapping("/room")
@Api(tags = "房间")
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/findBedUsage")
    @ApiOperation("查询床位示意视图数据")
    public ResultVo<BedUsageVo> findBedUsage(String floor) throws Exception {
        // 统计床位
        return roomService.findBedUsage(floor);

    }

    @GetMapping("/listRoom")
    @ApiOperation("查询床位列表")
    public ResultVo<List<Room>> listRoom() {
        // 创建查询条件包裹器、
        return ResultVo.ok(roomService.list());
    }
}
