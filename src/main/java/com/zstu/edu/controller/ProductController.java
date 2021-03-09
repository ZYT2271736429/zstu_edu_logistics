package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Product;
import com.zstu.edu.service.ProductService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物品 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 查询全部物品
     * @param queryCondition
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition){
        PageInfo<Product> productList=productService.getByCondition(queryCondition);
        return JsonResult.ok().data("productList",productList);
    }

    /**
     * 获得物品
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id){
        Product product=productService.getById(id);
        return JsonResult.ok().data("product",product);
    }

    /**
     * 新增物品
     * @param product
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Product product){
        Product product1=productService.add(product);
        return JsonResult.ok().data("product",product1);
    }

   /* *//**
     * 增加物品
     *
     * @return
     *//*
    @RequestMapping("add")
    public JsonResult add() {
        Product product = new Product();
        product.setName("羽毛球");
        product.setPrice((double) 90);
        product.setPhoto("/api/file/0889712508.jpg");
        product.setDescription("用于打球");
        product.setTotal(100);
        product.setProductTypeId(1);
        productService.add(product);
        product.setName("乒乓球");
        product.setPrice((double) 90);
        product.setPhoto("/api/file/0889712508.jpg");
        product.setDescription("用于打球");
        product.setTotal(100);
        product.setProductTypeId(2);
        productService.add(product);
        return JsonResult.ok();
    }*/

}
