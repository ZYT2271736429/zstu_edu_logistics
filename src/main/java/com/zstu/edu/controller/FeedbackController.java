package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Feedback;
import com.zstu.edu.service.FeedbackService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 反馈 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    /**
     * 新增评价
     *
     * @param feedback
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Feedback feedback) {
        feedbackService.add(feedback);
        return JsonResult.ok();
    }

    /**
     * 全部评价
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition) {
        PageInfo<Feedback> feedbackList = feedbackService.getByCondition(queryCondition);
        return JsonResult.ok().data("feedbackList", feedbackList);
    }

    /**
     * 获得单个评价
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Feedback feedback = feedbackService.getById(id);
        return JsonResult.ok().data("feedback", feedback);
    }

    /**
     * 删除评价
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public JsonResult delete(@RequestBody Integer id) {
        feedbackService.deleteById(id);
        return JsonResult.ok();
    }

    /**
     * 修改评价
     *
     * @param feedback
     * @return
     */
    @RequestMapping("update")
    public JsonResult update(@RequestBody Feedback feedback) {
        feedbackService.updateById(feedback);
        return JsonResult.ok();
    }

}
