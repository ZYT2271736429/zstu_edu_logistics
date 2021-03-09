package com.zstu.edu.mapper;

import com.zstu.edu.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 物品 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 按条件查询所有物品
     * @param name
     * @param stock
     * @param productTypeId
     * @return
     */
    List<Product> selectByCondition(@Param("name") String name,@Param("stock") Boolean stock,
                                    @Param("productTypeId") Integer productTypeId);

    /**
     * 物品增加
     * @param productId
     * @param number
     */
    void numberAdd(@Param("productId") Integer productId,@Param("number") Integer number);
}
