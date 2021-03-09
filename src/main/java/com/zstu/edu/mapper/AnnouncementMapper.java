package com.zstu.edu.mapper;

import com.zstu.edu.entity.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zstu.edu.util.JsonResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 校园公告 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    /**
     * 获取全部
     * @return
     */
    List<Announcement> selectAll();

    /**
     * 取消置顶
     */
    void setTopFalse();

    /**
     * 置顶
     * @param id
     */
    void setTopTrue(Integer id);

    /**
     * 获得置顶
     * @return
     */
    Announcement getTopTrue();
}
