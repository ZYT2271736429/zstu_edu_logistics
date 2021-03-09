package com.zstu.edu.controller;


import com.zstu.edu.entity.Repairman;
import com.zstu.edu.service.RepairmanService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 维修员 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/repairman")
public class RepairmanController {

    @Autowired
    RepairmanService repairmanService;

    /**
     * 注册维修员
     *
     * @return
     */
    @RequestMapping("register")
    public JsonResult register() {
        Repairman repairman = new Repairman();
        repairman.setName("维修员一号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员二号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员三号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员四号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员五号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员六号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员七号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        repairman.setName("维修员八号");
        repairman.setPhone("123456789");
        repairmanService.add(repairman);
        return JsonResult.ok();
    }

    /**
     * 获得所有维修员
     *
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll() {
        List<Repairman> repairmanList = repairmanService.getAll();
        return JsonResult.ok().data("repairmanList", repairmanList);
    }

    /**
     * 获得单个维修员
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Repairman repairman = repairmanService.getById(id);
        return JsonResult.ok().data("repairman", repairman);
    }

}
