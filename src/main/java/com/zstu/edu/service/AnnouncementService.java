package com.zstu.edu.service;

import com.zstu.edu.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zstu.edu.util.JsonResult;

import java.util.List;

/**
 * <p>
 * 校园公告 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface AnnouncementService extends IService<Announcement> {

    /**
     * 全部公告
     * @return
     */
    List<Announcement> all();

    /**
     * 单个公告
     * @param id
     * @return
     */
    Announcement getById(Integer id);

    /**
     * 删除公告
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 置顶公告
     * @param id
     */
    void top(Integer id);

    /**
     * 获得置顶公告
     * @return
     */
    Announcement getTop();
}
