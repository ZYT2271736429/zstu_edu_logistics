package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Buy;
import com.zstu.edu.entity.Complaint;
import com.zstu.edu.entity.Item;
import com.zstu.edu.mapper.BuyMapper;
import com.zstu.edu.service.BuyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.ItemService;
import com.zstu.edu.service.ProductService;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 申购 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Service
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy> implements BuyService {

    @Autowired
    BuyMapper buyMapper;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Override
    public Buy getById(Integer id) {
        Buy buy = buyMapper.selectById(id);
        buy.setItemList(itemService.getByBuyId(buy.getId()));
        for (Item item: buy.getItemList()) {
            item.setProduct(productService.getById(item.getProductId()));
        }
        return buy;
    }

    @Override
    public void add(Buy buy) {
        buyMapper.insert(buy);
        for (Item item : buy.getItemList()) {
            item.setBuyId(buy.getId());
            itemService.add(item);
        }
    }

    @Override
    public PageInfo<Buy> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Boolean status = jsonObject.getBoolean("status");
        Boolean statusIfOne = jsonObject.getBoolean("statusIfOne");
        PageHelper.startPage(current, size);
        List<Buy> buyList = buyMapper.selectByCondition(status,statusIfOne);
        for (Buy buy : buyList) {
            buy.setFacultyBuy(userService.getById(buy.getFacultyBuyId()));
            buy.setFacultyDeal(userService.getById(buy.getFacultyDealId()));
        }
        PageInfo<Buy> buyPageInfo = new PageInfo<>(buyList);
        return buyPageInfo;
    }

    @Override
    public void pass(Buy buy) {
        buyMapper.updateById(buy);
        List<Item> itemList = itemService.getByBuyId(buy.getId());
        for (Item item: itemList) {
            productService.numberAdd(item.getProductId(),item.getNumber());
        }
    }

    @Override
    public void refuse(Buy buy) {
        buyMapper.updateById(buy);
    }
}
