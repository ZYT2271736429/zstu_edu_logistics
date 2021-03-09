package com.zstu.edu.service;

import com.zstu.edu.entity.RepairType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 故障类型 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface RepairTypeService extends IService<RepairType> {

    /**
     * 新增故障类型
     * @param repairType
     */
    void add(RepairType repairType);

    /**
     * 所有故障类型
     * @return
     */
    List<RepairType> getAll();
}
