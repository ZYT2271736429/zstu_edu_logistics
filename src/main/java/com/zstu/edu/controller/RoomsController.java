package com.zstu.edu.controller;


import com.zstu.edu.entity.Rooms;
import com.zstu.edu.service.RoomsService;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 房间 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    RoomsService roomsService;

    /**
     * 根据宿舍楼id获取全部宿舍
     * @param buildingsId
     * @return
     */
    @RequestMapping("getbybuildingsid")
    public JsonResult getByBuildingsId(@RequestBody Integer buildingsId){
        List<Rooms> roomsList=roomsService.getByBuildingsId(buildingsId);
        return JsonResult.ok().data("roomsList",roomsList);
    }

    /**
     * 获取全部宿舍
     * @param floorsid
     * @return
     */
    @RequestMapping("getbyfloorsid")
    public JsonResult getByFloorsId(@RequestParam(required = false) Integer floorsid){
        List<Rooms> roomsList = roomsService.getByFloorsId(floorsid);
        return JsonResult.ok().data("roomsList",roomsList);
    }

    /**
     *获取房间的所有信息，包含学生、宿舍楼、楼层
     * @param id
     * @return
     */
    @RequestMapping("getroominfo")
    public JsonResult getRoomInfo(@RequestBody Integer id){
        Rooms rooms=roomsService.getRoomInfo(id);
        return JsonResult.ok().data("rooms",rooms);
    }

}
