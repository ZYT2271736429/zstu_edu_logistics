package com.zstu.edu.controller;


import com.zstu.edu.entity.Floors;
import com.zstu.edu.service.FloorsService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 楼层 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/floors")
public class FloorsController {

    @Autowired
    FloorsService floorsService;

    /**
     * 获取楼层信息
     *
     * @param buildingsId
     * @return
     */
    @RequestMapping("getbybuildingsid")
    public JsonResult getByBuildingsId(@RequestParam(required = false) Integer buildingsId) {
        List<Floors> floorsList = floorsService.getByBuildingsId(buildingsId);
        return JsonResult.ok().data("floorsList", floorsList);
    }

}
