package com.zstu.edu.mapper;

import com.zstu.edu.entity.Dorm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 宿舍 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface DormMapper extends BaseMapper<Dorm> {

    /**
     * 所有楼号
     * @return
     */
    List<String> getFloor();

    /**
     * 所有宿舍号
     * @return
     */
    List<String> getDormitory();
}
