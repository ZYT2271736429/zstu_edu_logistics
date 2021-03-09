package com.zstu.edu.controller;


import com.zstu.edu.entity.Dishes;
import com.zstu.edu.service.DishesService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜品 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    DishesService dishesService;

    /**
     * 获得所有菜品
     *
     * @param stallId
     * @return
     */
    @RequestMapping("getall")
    public JsonResult getAll(@RequestBody Integer stallId) {
        List<Dishes> dishesList = dishesService.getByStallId(stallId);
        return JsonResult.ok().data("dishesList", dishesList);
    }

    /**
     * 获得单个菜品
     *
     * @param id
     * @return
     */
    @RequestMapping("getone")
    public JsonResult getOne(@RequestBody Integer id) {
        Dishes dishes = dishesService.getById(id);
        return JsonResult.ok().data("dishes", dishes);
    }

    /**
     * 删除菜品
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public JsonResult delete(@RequestBody Integer id) {
        dishesService.delete(id);
        return JsonResult.ok();
    }

    /**
     * 更新菜品
     * @param dishes
     * @return
     */
    @RequestMapping("update")
    public JsonResult update(@RequestBody Dishes dishes){
        dishesService.updateById(dishes);
        return JsonResult.ok();
    }

    /**
     * 新增菜品
     * @param dishes
     * @return
     */
    @RequestMapping("add")
    public JsonResult add(@RequestBody Dishes dishes){
        dishesService.add(dishes);
        return JsonResult.ok();
    }

    /**
     * 新增
     *
     * @return
     */
    /*@RequestMapping("add")
    public JsonResult add() {
        Dishes dishes = new Dishes();
        dishes.setPrice((double) 10);
        for (int i = 1; i < 20; i++) {
            dishes.setStallId(i);
            dishes.setName("鱼香肉丝");
            dishesService.add(dishes);
        }

        dishes.setPrice((double) 12);
        for (int i = 1; i < 20; i++) {
            dishes.setStallId(i);
            dishes.setName("尖椒炒肉");
            dishesService.add(dishes);
        }

        dishes.setPrice((double) 17);
        for (int i = 1; i < 20; i++) {
            dishes.setStallId(i);
            dishes.setName("扬州炒饭");
            dishesService.add(dishes);
        }
        return JsonResult.ok();
    }*/

}
