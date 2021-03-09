package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Dishes;
import com.zstu.edu.mapper.DishesMapper;
import com.zstu.edu.service.DishesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜品 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-25
 */
@Service
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements DishesService {

    @Autowired
    DishesMapper dishesMapper;

    @Override
    public void add(Dishes dishes) {
        dishesMapper.insert(dishes);
    }

    @Override
    public List<Dishes> getByStallId(Integer stallId) {
        return dishesMapper.selectByStallId(stallId);
    }

    @Override
    public void delete(Integer id) {
        dishesMapper.deleteById(id);
    }
}
