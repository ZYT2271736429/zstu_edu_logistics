package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Stall;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zstu.edu.entity.StallVO;

import java.util.List;

/**
 * <p>
 * 档口 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface StallService extends IService<Stall> {

    /**
     * 新增档口
     * @param stall
     * @return
     */
    Integer add(Stall stall);

    /**
     * 所有档口
     * @param queryCondition
     * @return
     */
    PageInfo<Stall> getByCondition(String queryCondition);

    /**
     * 删除档口
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据食堂id获得档口
     * @param canteenId
     * @return
     */
    List<Stall> getByCanteenId(Integer canteenId);

    /**
     * 获得级联选择档口
     * @return
     */
    List<StallVO> getCascader();

    /**
     * 档口详情
     * @param id
     * @return
     */
    Stall getById(Integer id);

    /**
     * 更新档口卫生
     * @param condition
     */
    void updateHealth(String condition);
}
