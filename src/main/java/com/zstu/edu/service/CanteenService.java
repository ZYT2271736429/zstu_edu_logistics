package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Canteen;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 食堂 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface CanteenService extends IService<Canteen> {

    /**
     * 新增食堂
     * @param canteen
     */
    void add(Canteen canteen);

    /**
     * 所有食堂
     * @return
     */
    List<Canteen> getAll();
}
