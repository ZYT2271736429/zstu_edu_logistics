package com.zstu.edu.service;

import com.zstu.edu.entity.Rooms;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zstu.edu.entity.User;

import java.util.List;

/**
 * <p>
 * 房间 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
public interface RoomsService extends IService<Rooms> {

    /**
     * 新增房间
     * @param rooms
     */
    void add(Rooms rooms);

    /**
     * 根据楼层查询房间
     * @param floorsId
     * @return
     */
    List<Rooms> getByFloorsId(Integer floorsId);

    /**
     * 获取房间的所有信息，包含学生、宿舍楼、楼层
     * @param id
     * @return
     */
    Rooms getRoomInfo(Integer id);

    /**
     * 根据宿舍楼id获取全部宿舍
     * @param buildingsId
     * @return
     */
    List<Rooms> getByBuildingsId(Integer buildingsId);
}
