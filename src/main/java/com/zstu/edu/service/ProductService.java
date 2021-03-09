package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 物品 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface ProductService extends IService<Product> {

    /**
     * 新增物品
     * @param product
     */
    Product add(Product product);

    /**
     * 查询全部物品
     * @param queryCondition
     * @return
     */
    PageInfo<Product> getByCondition(String queryCondition);

    /**
     *
     * @param productId
     * @param number
     */
    void numberAdd(Integer productId, Integer number);
}
