package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Item;
import com.zstu.edu.mapper.ItemMapper;
import com.zstu.edu.service.ItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 申购清单 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public void add(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public List<Item> getByBuyId(Integer buyId) {
        return itemMapper.selectByBuyId(buyId);
    }
}
