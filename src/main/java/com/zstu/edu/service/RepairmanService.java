package com.zstu.edu.service;

import com.zstu.edu.entity.Repairman;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 维修员 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface RepairmanService extends IService<Repairman> {

    /**
     * 注册维修员
     * @param repairman
     */
    void add(Repairman repairman);

    /**
     * 获得所有维修员
     * @return
     */
    List<Repairman> getAll();
}
