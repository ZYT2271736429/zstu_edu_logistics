package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Canteen;
import com.zstu.edu.entity.Repair;
import com.zstu.edu.mapper.CanteenMapper;
import com.zstu.edu.service.CanteenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 食堂 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class CanteenServiceImpl extends ServiceImpl<CanteenMapper, Canteen> implements CanteenService {

    @Autowired
    CanteenMapper canteenMapper;

    @Override
    public void add(Canteen canteen) {
        canteenMapper.insert(canteen);
    }

    @Override
    public List<Canteen> getAll() {
        return canteenMapper.selectList(null);
    }

}
