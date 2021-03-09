package com.zstu.edu.controller;


import com.zstu.edu.entity.Dorm;
import com.zstu.edu.service.DormService;
import com.zstu.edu.util.JsonResult;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 宿舍 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/dorm")
public class DormController {

    @Autowired
    DormService dormService;

    /**
     * 新增宿舍
     *
     * @return
     */
    @RequestMapping("add")
    public JsonResult add() {
        Integer n = 1;
        Dorm dorm = new Dorm();
        for (int i = 1; i < 17; i++) {
            dorm.setFloor(i + "号楼");
            if (i < 8) {
                dorm.setType(0);
                dorm.setBedNumber(4);
                for (int j = 1; j < 7; j++) {
                    for (int k = 1; k < 20; k++) {
                        if (k < 10) {
                            dorm.setDormitory(j + "0" + k);
                        } else {
                            dorm.setDormitory(j + "" + k);
                        }
                        for (int l = 1; l < 5; l++) {
                            dorm.setBed(l + "");
                            dormService.add(dorm);
                        }
                    }
                }
            } else {
                dorm.setType(1);
                dorm.setBedNumber(4);
                for (int j = 1; j < 7; j++) {
                    for (int k = 1; k < 20; k++) {
                        if (k < 10) {
                            dorm.setDormitory(j + "0" + k);
                        } else {
                            dorm.setDormitory(j + "" + k);
                        }
                        for (int l = 1; l < 5; l++) {
                            dorm.setBed(l + "");
                            dormService.add(dorm);
                        }
                    }
                }
            }
        }
        return JsonResult.ok();
    }

    /**
     * 所有楼号
     * @return
     */
    @RequestMapping("getfloor")
    public JsonResult getFloor(){
        List<String> floorList= dormService.getFloor();
        return JsonResult.ok().data("floorList",floorList);

    }

    /**
     * 所有宿舍号
     * @return
     */
    @RequestMapping("getdormitory")
    public JsonResult getDormitory(){
        List<String> dormitoryList=dormService.getDormitory();
        return JsonResult.ok().data("dormitoryList",dormitoryList);
    }



}
