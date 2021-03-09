package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Product;
import com.zstu.edu.entity.Stall;
import com.zstu.edu.mapper.ProductMapper;
import com.zstu.edu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 物品 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductTypeService productTypeService;

    @Override
    public Product add(Product product) {
        productMapper.insert(product);
        return product;
    }

    @Override
    public PageInfo<Product> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        String name = jsonObject.getString("name");
        Boolean stock = jsonObject.getBoolean("stock");
        Integer productTypeId = jsonObject.getInteger("productTypeId");
        PageHelper.startPage(current, size);
        List<Product> productList = productMapper.selectByCondition(name, stock, productTypeId);
        for (Product product : productList) {
            product.setProductType(productTypeService.getById(product.getProductTypeId()));
        }
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);
        return productPageInfo;
    }

    @Override
    public void numberAdd(Integer productId, Integer number) {
       productMapper.numberAdd(productId,number);
    }
}
