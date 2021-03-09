package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Buy;
import com.zstu.edu.service.BuyService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 申购 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    BuyService buyService;

    /**
     * 申购详情
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id){
        Buy buy = buyService.getById(id);
        return JsonResult.ok().data("buy",buy);
    }

    /**
     * 申购
     * @param buy
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Buy buy){
        buyService.add(buy);
        return JsonResult.ok();
    }

    /**
     * 申购历史
     * @param queryCondition
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition){
        PageInfo<Buy> buyList=buyService.getByCondition(queryCondition);
        return JsonResult.ok().data("buyList",buyList);
    }

    /**
     * 审核通过
     * @param buy
     * @return
     */
    @RequestMapping("pass")
    public JsonResult pass(@RequestBody Buy buy){
        buyService.pass(buy);
        return JsonResult.ok();
    }

    /**
     * 审核未通过
     * @param buy
     * @return
     */
    @RequestMapping("refuse")
    public JsonResult refuse(@RequestBody Buy buy){
        buyService.refuse(buy);
        return JsonResult.ok();
    }
}
