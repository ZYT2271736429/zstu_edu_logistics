package com.zstu.edu.controller;


import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Role;
import com.zstu.edu.entity.UserRole;
import com.zstu.edu.service.UserRoleService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    /**
     * 查询全部权限
     * @return
     */
    @RequestMapping("getbycondition")
    public JsonResult getByCondition(@RequestBody String queryCondition){
       PageInfo<UserRole> userRoleList = userRoleService.getByCondition(queryCondition);
        return JsonResult.ok().data("userRoleList",userRoleList);
    }

    /**
     * 取消权限
     * @param id
     * @return
     */
    @RequestMapping("deletebyid")
    public JsonResult deleteById(@RequestBody Integer id){
        userRoleService.deleteById(id);
        return JsonResult.ok();
    }

    /**
     * 新增权限
     * @param condition
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody String condition){
        userRoleService.add(condition);
        return JsonResult.ok();
    }

}
