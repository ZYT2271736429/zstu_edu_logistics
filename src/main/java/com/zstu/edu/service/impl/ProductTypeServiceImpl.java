package com.zstu.edu.service.impl;

import com.zstu.edu.entity.ProductType;
import com.zstu.edu.mapper.ProductMapper;
import com.zstu.edu.mapper.ProductTypeMapper;
import com.zstu.edu.service.ProductTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 物品类型 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public void add(ProductType productType) {
        productTypeMapper.insert(productType);
    }

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectList(null);
    }
}
