package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Complaint;
import com.zstu.edu.entity.Repair;
import com.zstu.edu.mapper.ComplaintMapper;
import com.zstu.edu.service.ComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.StallService;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 投诉 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

    @Autowired
    ComplaintMapper complaintMapper;

    @Autowired
    StallService stallService;

    @Autowired
    UserService userService;

    @Override
    public void add(Complaint complaint) {
        complaintMapper.insert(complaint);
    }

    @Override
    public PageInfo<Complaint> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Integer userId = jsonObject.getInteger("userId");
        Integer status = jsonObject.getInteger("status");
        PageHelper.startPage(current, size);
        List<Complaint> complaintList = complaintMapper.selectByCondition(userId, status);
        for (Complaint complaint : complaintList) {
            complaint.setStall(stallService.getById(complaint.getStallId()));
            complaint.setUser(userService.getById(complaint.getUserId()));
        }
        PageInfo<Complaint> complaintPageInfo = new PageInfo<>(complaintList);
        return complaintPageInfo;
    }

    @Override
    public Complaint getById(Integer id) {
        Complaint complaint = complaintMapper.selectById(id);
        complaint.setStall(stallService.getById(complaint.getStallId()));
        complaint.setUser(userService.getById(complaint.getUserId()));
        return complaint;
    }
}
