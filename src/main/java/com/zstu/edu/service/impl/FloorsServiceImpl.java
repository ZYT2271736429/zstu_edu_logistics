package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Floors;
import com.zstu.edu.entity.Rooms;
import com.zstu.edu.mapper.FloorsMapper;
import com.zstu.edu.service.FloorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 楼层 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Service
public class FloorsServiceImpl extends ServiceImpl<FloorsMapper, Floors> implements FloorsService {

    @Autowired
    FloorsMapper floorsMapper;

    @Autowired
    RoomsService roomsService;

    @Override
    public Integer add(Floors floors) {
        floorsMapper.insert(floors);
        return floors.getId();
    }

    @Override
    public List<Floors> getByBuildingsId(Integer buildingsId) {
        List<Floors> floorsList = floorsMapper.selectByBuildingsId(buildingsId);
        for (Floors floors : floorsList) {
            floors.setRoomsList(roomsService.getByFloorsId(floors.getId()));
        }
        return floorsList;
    }
}
