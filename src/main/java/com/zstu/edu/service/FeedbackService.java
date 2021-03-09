package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 反馈 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 新增评价
     *
     * @param feedback
     */
    void add(Feedback feedback);

    /**
     * 全部评价
     *
     * @param queryCondition
     * @return
     */
    PageInfo<Feedback> getByCondition(String queryCondition);

    /**
     * 删除评价
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 更新评价
     *
     * @param feedback
     * @return
     */
    @Override
    boolean updateById(Feedback feedback);
}
