package com.zstu.edu.mapper;

import com.zstu.edu.entity.Dishes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜品 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-25
 */
@Repository
public interface DishesMapper extends BaseMapper<Dishes> {

    /**
     * 根据档口id获得菜品
     * @param stallId
     * @return
     */
    List<Dishes> selectByStallId(Integer stallId);
}
