package com.zstu.edu.mapper;

import com.zstu.edu.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 反馈 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {

    /**
     * 查询菜品评分平均数
     * @param dishesId
     * @return
     */
    Double selectScoreAvgByDishesId(Integer dishesId);

    /**
     * 查询档口评分平均数
     * @param stallId
     * @return
     */
    Double selectScoreAvgByStallId(Integer stallId);

    /**
     * 按条件查询全部评价
     * @param userId
     * @return
     */
    List<Feedback> selectByCondition(@Param("userId") Integer userId,@Param("dishesId") Integer dishesId);
}
