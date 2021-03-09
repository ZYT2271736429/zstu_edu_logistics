package com.zstu.edu.service;

import com.zstu.edu.entity.Dishes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜品 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-25
 */
public interface DishesService extends IService<Dishes> {

    /**
     * 新增菜品
     * @param dishes
     */
    void add(Dishes dishes);

    /**
     * 根据档口id获得菜品
     * @param stallId
     * @return
     */
    List<Dishes> getByStallId(Integer stallId);

    /**
     * 删除菜品
     * @param id
     */
    void delete(Integer id);
}
