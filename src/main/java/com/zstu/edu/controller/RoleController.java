package com.zstu.edu.controller;


import com.zstu.edu.entity.Role;
import com.zstu.edu.service.RoleService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 查询全部角色
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(){
        List<Role> roleList=roleService.getAll();
        return JsonResult.ok().data("roleList",roleList);
    }


}
