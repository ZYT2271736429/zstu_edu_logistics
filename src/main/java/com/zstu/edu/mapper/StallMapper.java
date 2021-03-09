package com.zstu.edu.mapper;

import com.zstu.edu.entity.Stall;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 档口 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface StallMapper extends BaseMapper<Stall> {

    /**
     * 根据条件查询档口
     *
     * @param canteenId
     * @param stallName
     * @return
     */
    List<Stall> selectByCondition(@Param("canteenId") Integer canteenId, @Param("stallName") String stallName);

    /**
     * 根据食堂id查询档口
     *
     * @param canteenId
     * @return
     */
    List<Stall> selectByCanteenId(Integer canteenId);

    /**
     * 更新卫生状况
     *
     * @param id
     * @param healthPhoto
     * @param healthScore
     * @param collectionTime
     */
    void updateHealth(@Param("id") Integer id, @Param("healthPhoto") String healthPhoto, @Param("healthScore") Double healthScore,
                      @Param("collectionTime") Date collectionTime);
}
