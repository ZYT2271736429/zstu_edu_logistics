package com.zstu.edu.service;

import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Buy;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申购 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
public interface BuyService extends IService<Buy> {

    /**
     * 申购详情
     *
     * @param id
     * @return
     */
    Buy getById(Integer id);

    /**
     * 申购
     *
     * @param buy
     */
    void add(Buy buy);

    /**
     * 申购历史
     *
     * @param queryCondition
     * @return
     */
    PageInfo<Buy> getByCondition(String queryCondition);

    /**
     * 审核通过
     *
     * @param buy
     */
    void pass(Buy buy);

    /**
     * 审核未通过
     *
     * @param buy
     */
    void refuse(Buy buy);
}
