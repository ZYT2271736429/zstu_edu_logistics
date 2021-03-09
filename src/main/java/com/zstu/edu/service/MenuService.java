package com.zstu.edu.service;

import com.zstu.edu.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-19
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据用户id获得菜单
     * @param id
     * @return
     */
    List<Menu> getByUserId(Integer id);

}
