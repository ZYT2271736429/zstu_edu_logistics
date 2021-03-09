package com.zstu.edu.service;

import com.zstu.edu.entity.Floors;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zstu.edu.entity.Rooms;

import java.util.List;

/**
 * <p>
 * 楼层 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
public interface FloorsService extends IService<Floors> {

    /**
     * 新增楼层
     * @param floors
     * @return
     */
    Integer add(Floors floors);

    /**
     * 根据宿舍楼查询楼层
     * @param buildingsId
     * @return
     */
    List<Floors> getByBuildingsId(Integer buildingsId);
}
