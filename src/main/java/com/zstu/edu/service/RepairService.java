package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Repair;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 网上保修 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface RepairService extends IService<Repair> {

    /**
     * 新增报修
     * @param repair
     */
    Integer add(Repair repair) throws ParseException;

    /**
     * 获得详情
     * @param id
     * @return
     */
    Repair getById(Integer id);

    /**
     * 待处理报修
     * @param queryCondition
     * @return
     */
    PageInfo<Repair> getDeal(String queryCondition);

    /**
     * 未完成报修
     * @param queryCondition
     * @return
     */
    PageInfo<Repair> getUndone(String queryCondition);

    /**
     * 已完成报修
     * @param queryCondition
     * @return
     */
    PageInfo<Repair> getDone(String queryCondition);

    /**
     * 报修历史
     * @param queryCondition
     * @return
     */
    PageInfo<Repair> getAll(String queryCondition);

    /**
     * 报修进度
     * @param userId
     * @return
     */
    Repair status(Integer userId);

    /**
     * 报修人的报修历史
     * @param queryCondition
     * @return
     */
    PageInfo<Repair> getStudentAll(String queryCondition);
}
