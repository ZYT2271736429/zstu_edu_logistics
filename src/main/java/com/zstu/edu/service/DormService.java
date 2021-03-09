package com.zstu.edu.service;

import com.zstu.edu.entity.Dorm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宿舍 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface DormService extends IService<Dorm> {

    /**
     * 新增宿舍
     * @param dorm
     */
    void add(Dorm dorm);

    /**
     * 所有楼号
     * @return
     */
    List<String> getFloor();

    /**
     * 所有宿舍号
     * @return
     */
    List<String> getDormitory();
}
