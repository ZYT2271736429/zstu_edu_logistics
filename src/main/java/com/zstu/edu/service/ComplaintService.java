package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Complaint;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 投诉 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
public interface ComplaintService extends IService<Complaint> {

    /**
     * 新增投诉
     * @param complaint
     */
    void add(Complaint complaint);

    /**
     * 全部投诉
     * @param queryCondition
     * @return
     */
    PageInfo<Complaint> getByCondition(String queryCondition);

    /**
     * 获得投诉
     * @param id
     * @return
     */
    Complaint getById(Integer id);
}
