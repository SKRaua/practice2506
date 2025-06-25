package org.skraua.yyzxbackend.service.Impl;

import java.util.List;

import org.skraua.yyzxbackend.mapper.BedMapper;
import org.skraua.yyzxbackend.mapper.RoomMapper;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.Room;
import org.skraua.yyzxbackend.service.RoomService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedUsageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    private BedMapper bedMapper;

    @Override
    public ResultVo<BedUsageVo> findBedUsage(String floor) throws Exception {
        // 统计床位
        BedUsageVo bedUsageVo = bedMapper.selectBedCountVo();
        QueryWrapper<Room> qwRoomList = new QueryWrapper<>();
        qwRoomList.eq("room_floor", floor);
        // 查询所有房间
        List<Room> roomList = list(qwRoomList);

        for (Room room : roomList) {
            // 查询每个房间的床位信息
            QueryWrapper<Bed> qwBedList = new QueryWrapper<>();
            qwBedList.eq("room_no", room.getRoomNo());
            // 获取房间的床位列表
            List<Bed> bedList = bedMapper.selectList(qwBedList);
            room.setBedList(bedList);
        }
        bedUsageVo.setRoomList(roomList);
        return ResultVo.ok(bedUsageVo);
    }

}
