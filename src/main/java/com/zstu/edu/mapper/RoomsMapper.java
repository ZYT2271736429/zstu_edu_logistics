package com.zstu.edu.mapper;

import com.zstu.edu.entity.Rooms;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 房间 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Repository
public interface RoomsMapper extends BaseMapper<Rooms> {

    /**
     * 根据楼层查询房间
     * @param floorsId
     * @return
     */
    List<Rooms> selectByFloorsId(Integer floorsId);

    /**
     * 根据宿舍楼id获取全部宿舍
     * @param buildingsId
     * @return
     */
    List<Rooms> selectByBuildingsId(Integer buildingsId);
}
