package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.pojo.Room;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedUsageVo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description
 */
public interface RoomService extends IService<Room> {
    public ResultVo<BedUsageVo> findBedUsage(String floor) throws Exception;
}
