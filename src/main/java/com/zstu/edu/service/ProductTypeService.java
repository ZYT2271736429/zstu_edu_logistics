package com.zstu.edu.service;

import com.zstu.edu.entity.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 物品类型 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface ProductTypeService extends IService<ProductType> {

    /**
     * 新增物品类型
     * @param productType
     */
    void add(ProductType productType);

    /**
     * 查询全部物品类型
     * @return
     */
    List<ProductType> getAll();
}
