package com.zstu.edu.mapper;

import com.zstu.edu.entity.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 申购清单 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Repository
public interface ItemMapper extends BaseMapper<Item> {

    /**
     * 根据申购id获得清单
     * @param buyId
     * @return
     */
    List<Item> selectByBuyId(Integer buyId);
}
