package com.zstu.edu.controller;


import com.zstu.edu.entity.Announcement;
import com.zstu.edu.service.AnnouncementService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 校园公告 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    /**
     * 发布公告
     *
     * @param announcement
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Announcement announcement) {
        announcementService.save(announcement);
        return JsonResult.ok();
    }

    /**
     * 查询全部公告
     *
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll() {
        List<Announcement> announcementList = announcementService.all();
        return JsonResult.ok().data("announcementList", announcementList);
    }

    /**
     * 查询单个公告
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Announcement announcement = announcementService.getById(id);
        return JsonResult.ok().data("announcement", announcement);
    }

    /**
     * 删除公告
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public JsonResult delete(@RequestBody Integer id) {
        announcementService.deleteById(id);
        return JsonResult.ok();
    }

    /**
     * 置顶公告
     *
     * @param id
     * @return
     */
    @RequestMapping("top")
    public JsonResult top(@RequestBody Integer id) {
        announcementService.top(id);
        return JsonResult.ok();
    }

    /**
     * 获得置顶公告
     *
     * @return
     */
    @RequestMapping("gettop")
    public JsonResult getTop() {
        Announcement announcement = announcementService.getTop();
        return JsonResult.ok().data("announcementTop", announcement);
    }

    @RequestMapping("update")
    public JsonResult update(@RequestBody Announcement announcement) {
        announcementService.updateById(announcement);
        return JsonResult.ok();
    }

}
