package com.zstu.edu.controller;


import com.zstu.edu.entity.Menu;
import com.zstu.edu.service.MenuService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 根据用户名id查询用户菜单
     */
    @RequestMapping("all")
    public JsonResult all(@RequestBody Integer id) {
        List<Menu> menuList = menuService.getByUserId(id);
        return JsonResult.ok().data("data", menuList);
    }

}
