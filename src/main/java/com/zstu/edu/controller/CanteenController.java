package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Canteen;
import com.zstu.edu.service.CanteenService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.util.JAXBSource;
import java.util.List;

/**
 * <p>
 * 食堂 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/canteen")
public class CanteenController {

    @Autowired
    CanteenService canteenService;

    /**
     * 新增食堂
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(){
        Canteen canteen = new Canteen();
        canteen.setHead("总经理");
        canteen.setPhone("123456789");
        canteen.setName("桂花园一楼");
        canteenService.add(canteen);
        canteen.setName("桂花园二楼");
        canteenService.add(canteen);
        canteen.setName("桂花园三楼");
        canteenService.add(canteen);
        canteen.setName("玫瑰园一楼");
        canteenService.add(canteen);
        canteen.setName("玫瑰园二楼");
        canteenService.add(canteen);
        canteen.setName("玫瑰园三楼");
        canteenService.add(canteen);
        canteen.setName("紫薇阁一楼");
        canteenService.add(canteen);
        canteen.setName("紫薇阁二楼");
        canteenService.add(canteen);
        canteen.setName("紫薇阁三楼");
        canteenService.add(canteen);
        return JsonResult.ok();
    }

    /**
     * 所有食堂
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(){
        List<Canteen> canteenList=canteenService.getAll();
        return JsonResult.ok().data("canteenList",canteenList);
    }
}
