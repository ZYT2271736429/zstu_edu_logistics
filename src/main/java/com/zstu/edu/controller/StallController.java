package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Stall;
import com.zstu.edu.entity.StallVO;
import com.zstu.edu.service.StallService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 档口 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/stall")
public class StallController {

    @Autowired
    StallService stallService;

    /**
     * 所有档口
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition) {
        PageInfo<Stall> stallList = stallService.getByCondition(queryCondition);
        return JsonResult.ok().data("stallList", stallList);
    }

    /**
     * 获得级联选择档口
     *
     * @return
     */
    @RequestMapping("getcascader")
    public JsonResult getCascader() {
        List<StallVO> stallList = stallService.getCascader();
        return JsonResult.ok().data("stallList", stallList);
    }

    /**
     * 获得档口
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Stall stall = stallService.getById(id);
        return JsonResult.ok().data("stall", stall);
    }

    /**
     * 新增档口
     *
     * @param stall
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Stall stall) {
        stallService.add(stall);
        return JsonResult.ok();
    }

    /**
     * 删除档口
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public JsonResult delete(@RequestBody Integer id) {
        stallService.delete(id);
        return JsonResult.ok();
    }

    /**
     * 更新档口
     *
     * @param stall
     * @return
     */
    @RequestMapping("update")
    public JsonResult update(@RequestBody Stall stall) {
        stallService.updateById(stall);
        return JsonResult.ok();
    }

    /**
     * 更新档口卫生
     * @param condition
     * @return
     */
    @RequestMapping("updatehealth")
    public JsonResult updateHealth(@RequestBody String condition){
        stallService.updateHealth(condition);
        return JsonResult.ok();
    }

    /**
     * 新增档口
     *
     * @param
     * @return
     */
    /*@RequestMapping("add")
    public JsonResult add() {
        Stall stall = new Stall();
        for (int i = 1; i < 10; i++) {
            stall.setCanteenId(i);
            stall.setName("缙云烧饼");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("无骨鱼");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("酸菜鱼");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("衢州小吃");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("张亮麻辣烫");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("麻辣香锅");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
            stall.setName("自选套餐");
            stall.setHead("善堂负责人");
            stall.setPhone("12345678");
            stallService.add(stall);
        }
        return JsonResult.ok().data("id", null);
    }*/

}
