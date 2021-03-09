package com.zstu.edu.mapper;

import com.zstu.edu.entity.Floors;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 楼层 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Repository
public interface FloorsMapper extends BaseMapper<Floors> {

    /**
     * 根据宿舍楼id查询楼层
     * @param buildingsId
     * @return
     */
    List<Floors> selectByBuildingsId(Integer buildingsId);
}
