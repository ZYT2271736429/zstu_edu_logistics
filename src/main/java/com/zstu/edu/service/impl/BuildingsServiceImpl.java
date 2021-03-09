package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zstu.edu.entity.Buildings;
import com.zstu.edu.entity.Floors;
import com.zstu.edu.entity.Rooms;
import com.zstu.edu.entity.User;
import com.zstu.edu.mapper.BuildingsMapper;
import com.zstu.edu.service.BuildingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.FloorsService;
import com.zstu.edu.service.RoomsService;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 宿舍楼 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Service
public class BuildingsServiceImpl extends ServiceImpl<BuildingsMapper, Buildings> implements BuildingsService {

    @Autowired
    BuildingsMapper buildingsMapper;

    @Autowired
    FloorsService floorsService;

    @Autowired
    RoomsService roomsService;

    @Autowired
    UserService userService;

    @Override
    public List<Buildings> getAll() {
        List<Buildings> buildingsList = buildingsMapper.selectList(null);
        for (Buildings buildings : buildingsList) {
            buildings.setStudentCount(getStudentCountByBuildingsId(buildings.getId()));
        }
        return buildingsList;
    }

    @Override
    public Integer getStudentCountByBuildingsId(Integer buildingsId) {
        List<Floors> floorsList = floorsService.getByBuildingsId(buildingsId);
        ArrayList<Rooms> roomsArrayList = new ArrayList<>();
        for (Floors floors : floorsList) {
            List<Rooms> roomsList = roomsService.getByFloorsId(floors.getId());
            for (Rooms rooms : roomsList) {
                roomsArrayList.add(rooms);
            }
        }
        Integer count = 0;
        for (Rooms rooms : roomsArrayList) {
            List<User> userList = userService.getListByRoomsId(rooms.getId());
            count += userList.size();
        }
        return count;
    }

    @Override
    public void add(String condition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(condition);
        String name = jsonObject.getString("name");
        Integer floorCount = jsonObject.getInteger("floorCount");
        Integer roomCount = jsonObject.getInteger("roomCount");
        Buildings buildings = new Buildings();
        buildings.setName(name);
        buildings.setFloorCount(floorCount);
        buildings.setRoomCount(roomCount);
        buildingsMapper.insert(buildings);
        Floors floors = new Floors();
        floors.setBuildingId(buildings.getId());
        Rooms rooms = new Rooms();
        rooms.setBuildingId(buildings.getId());
        rooms.setPeoplenum(5);
        rooms.setStatus(1);
        Integer floorsId = null;
        for (int i = 1; i <= floorCount; i++) {
            floors.setLayer(i);
            floorsId = floorsService.add(floors);
            rooms.setFloorsId(floorsId);
            for (int j = 1; j <= roomCount; j++) {
                rooms.setNumber(i * 100 + j);
                roomsService.add(rooms);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        buildingsMapper.deleteById(id);
    }
}
