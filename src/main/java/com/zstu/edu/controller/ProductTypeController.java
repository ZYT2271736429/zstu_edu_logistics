package com.zstu.edu.controller;


import com.sun.org.apache.bcel.internal.generic.JSR;
import com.zstu.edu.entity.ProductType;
import com.zstu.edu.service.ProductTypeService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 物品类型 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/product-type")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    /**
     * 查询全部物品类型
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(){
        List<ProductType> productTypeList= productTypeService.getAll();
        return JsonResult.ok().data("productTypeList",productTypeList);
    }

    /**
     * 新增物品类型
     */
    @RequestMapping("add")
    public JsonResult add(){
        ProductType productType = new ProductType();
        productType.setType("体育用品");
        productTypeService.add(productType);
        productType.setType("生活用品");
        productTypeService.add(productType);
        productType.setType("教学用品");
        productTypeService.add(productType);
        productType.setType("宿舍用品");
        productTypeService.add(productType);
        return JsonResult.ok();
    }

}
