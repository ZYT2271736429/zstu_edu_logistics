package com.zstu.edu.controller;


import com.zstu.edu.entity.Buildings;
import com.zstu.edu.service.BuildingsService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 宿舍楼 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    BuildingsService buildingsService;

    /**
     * 新增宿舍楼
     * @param condition
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody String condition){
        buildingsService.add(condition);
        return JsonResult.ok();
    }

    /**
     * 删除宿舍楼
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public JsonResult delete(@RequestBody Integer id){
        buildingsService.delete(id);
        return JsonResult.ok();
    }

    /**
     * 获取全部宿舍楼
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(){
        List<Buildings> buildingsList = buildingsService.getAll();
        return JsonResult.ok().data("buildingsList",buildingsList);
    }

}
