package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Buildings;
import com.zstu.edu.entity.Floors;
import com.zstu.edu.entity.Rooms;
import com.zstu.edu.mapper.RoomsMapper;
import com.zstu.edu.service.BuildingsService;
import com.zstu.edu.service.FloorsService;
import com.zstu.edu.service.RoomsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 房间 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Service
public class RoomsServiceImpl extends ServiceImpl<RoomsMapper, Rooms> implements RoomsService {

    @Autowired
    RoomsMapper roomsMapper;

    @Autowired
    BuildingsService buildingsService;

    @Autowired
    FloorsService floorsService;

    @Autowired
    UserService userService;

    @Override
    public void add(Rooms rooms) {
        roomsMapper.insert(rooms);
    }

    @Override
    public List<Rooms> getByFloorsId(Integer floorsId) {
        return roomsMapper.selectByFloorsId(floorsId);
    }

    @Override
    public Rooms getRoomInfo(Integer id) {
        Rooms rooms = roomsMapper.selectById(id);
        Buildings buildings = buildingsService.getById(rooms.getBuildingId());
        rooms.setBuildings(buildings);
        rooms.setBuildingsName(buildings.getName());
        Floors floors = floorsService.getById(rooms.getFloorsId());
        rooms.setFloors(floors);
        rooms.setFloorsName(floors.getLayer());
        rooms.setUserList(userService.getListByRoomsId(rooms.getId()));
        return rooms;
    }

    @Override
    public List<Rooms> getByBuildingsId(Integer buildingsId) {
        return roomsMapper.selectByBuildingsId(buildingsId);
    }
}
