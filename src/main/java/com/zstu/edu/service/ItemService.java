package com.zstu.edu.service;

import com.zstu.edu.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 申购清单 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
public interface ItemService extends IService<Item> {

    /**
     * 增加清单
     * @param item
     * @return
     */
    void add(Item item);

    /**
     * 根据申购id获得清单
     * @param buyId
     * @return
     */
    List<Item> getByBuyId(Integer buyId);
}
