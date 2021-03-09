package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Announcement;
import com.zstu.edu.mapper.AnnouncementMapper;
import com.zstu.edu.service.AnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 校园公告 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

    @Autowired
    AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> all() {
        return announcementMapper.selectAll();
    }

    @Override
    public Announcement getById(Integer id) {
        return announcementMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        announcementMapper.deleteById(id);
    }

    @Override
    public void top(Integer id) {
        announcementMapper.setTopFalse();
        announcementMapper.setTopTrue(id);
    }

    @Override
    public Announcement getTop() {
        return announcementMapper.getTopTrue();
    }
}
