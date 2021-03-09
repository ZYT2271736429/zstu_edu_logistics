package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Repair;
import com.zstu.edu.service.RepairService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 网上保修 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    RepairService repairService;

    /**
     * 新增报修
     *
     * @param repair
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Repair repair) throws ParseException {
        Integer id = repairService.add(repair);
        return JsonResult.ok().data("id", id);
    }

    /**
     * 更新维修
     *
     * @param repair
     * @return
     */
    @RequestMapping("update")
    public JsonResult update(@RequestBody Repair repair) {
        repairService.updateById(repair);
        return JsonResult.ok();
    }

    /**
     * 获得详情
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Repair repair = repairService.getById(id);
        return JsonResult.ok().data("repair", repair);
    }

    /**
     * 待处理报修
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getdeal")
    public JsonResult getDeal(@RequestBody String queryCondition) {
        PageInfo<Repair> repairList = repairService.getDeal(queryCondition);
        return JsonResult.ok().data("repairList", repairList);
    }

    /**
     * 未完成报修
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getundone")
    public JsonResult getUndone(@RequestBody String queryCondition) {
        PageInfo<Repair> repairList = repairService.getUndone(queryCondition);
        return JsonResult.ok().data("repairList", repairList);
    }

    /**
     * 已完成报修
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getdone")
    public JsonResult getDone(@RequestBody String queryCondition) {
        PageInfo<Repair> repairList = repairService.getDone(queryCondition);
        return JsonResult.ok().data("repairList", repairList);
    }

    /**
     * 报修历史
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(@RequestBody String queryCondition) {
        PageInfo<Repair> repairList = repairService.getAll(queryCondition);
        return JsonResult.ok().data("repairList", repairList);
    }

    /**
     * 报修进度
     * @param userId
     * @return
     */
    @RequestMapping("status")
    public JsonResult status(@RequestBody Integer userId){
       Repair repair= repairService.status(userId);
        return JsonResult.ok().data("repair",repair);
    }

    /**
     * 报修人的报修历史
     * @param queryCondition
     * @return
     */
    @RequestMapping("getstudentall")
    public JsonResult getStudentAll(@RequestBody String queryCondition) {
        PageInfo<Repair> repairList = repairService.getStudentAll(queryCondition);
        return JsonResult.ok().data("repairList", repairList);
    }
}
