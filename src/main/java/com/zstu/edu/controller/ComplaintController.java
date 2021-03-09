package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Complaint;
import com.zstu.edu.service.CanteenService;
import com.zstu.edu.service.ComplaintService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 投诉 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    /**
     * 新增投诉
     *
     * @param complaint
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Complaint complaint) {
        complaintService.add(complaint);
        return JsonResult.ok();
    }

    /**
     * 投诉记录
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition) {
        PageInfo<Complaint> complaintList = complaintService.getByCondition(queryCondition);
        return JsonResult.ok().data("complaintList", complaintList);
    }

    /**
     * 获得投诉
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Complaint complaint = complaintService.getById(id);
        return JsonResult.ok().data("complaint", complaint);
    }

    /**
     * 完成投诉
     *
     * @param complaint
     * @return
     */
    @RequestMapping("update")
    public JsonResult update(@RequestBody Complaint complaint) {
        complaintService.updateById(complaint);
        return JsonResult.ok();
    }

}
