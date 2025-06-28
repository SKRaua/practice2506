package org.skraua.yyzxbackend.service;

import java.util.List;

import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.utils.ResultVo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description
 */
public interface NurseContentService extends IService<NurseContent> {
    public ResultVo<List<NurseContent>> listByLevel(Integer levelId) throws Exception;

    public ResultVo<Void> update(NurseContent nurseContent) throws Exception;

    public ResultVo<Void> delete(NurseContent nurseContent) throws Exception;
}
