package com.zstu.edu.controller;


import com.zstu.edu.entity.RepairType;
import com.zstu.edu.service.RepairService;
import com.zstu.edu.service.RepairTypeService;
import com.zstu.edu.service.RoleService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 故障类型 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/repair-type")
public class RepairTypeController {

    @Autowired
    RepairTypeService repairTypeService;

    /**
     * 新增维修类型
     *
     * @return
     */
    @RequestMapping("add")
    public JsonResult add() {
        RepairType repairType = new RepairType();
        repairType.setType("水电维修");
        repairTypeService.add(repairType);

        repairType.setType("家具维修");
        repairTypeService.add(repairType);

        repairType.setType("网络维修");
        repairTypeService.add(repairType);

        repairType.setType("家具换新");
        repairTypeService.add(repairType);

        return JsonResult.ok();
    }

    /**
     * 获得所有故障类型
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(){
        List<RepairType> repairTypeList=repairTypeService.getAll();
        return JsonResult.ok().data("repairTypeList",repairTypeList);
    }


}
