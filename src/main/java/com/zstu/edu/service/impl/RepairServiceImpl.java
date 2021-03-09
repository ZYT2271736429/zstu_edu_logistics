package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Repair;
import com.zstu.edu.mapper.RepairMapper;
import com.zstu.edu.service.RepairService;
import com.zstu.edu.service.RepairTypeService;
import com.zstu.edu.service.RepairmanService;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 网上保修 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {

    @Autowired
    RepairMapper repairMapper;

    @Autowired
    RepairmanService repairmanService;

    @Autowired
    UserService userService;

    @Autowired
    RepairTypeService repairTypeService;

    @Override
    public Integer add(Repair repair) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        repair.setOrderN(sdf.format(new Date()));
        repair.setRepairStatus(1);
        repairMapper.insert(repair);
        return repair.getId();
    }

    @Override
    public Repair getById(Integer id) {
        Repair repair = repairMapper.selectById(id);
        repair.setUser(userService.getById(repair.getStudentId()));
        repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
        repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        return repair;
    }

    @Override
    public PageInfo<Repair> getDeal(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        PageHelper.startPage(current, size);
        List<Repair> repairList = repairMapper.selectByRepairStatus(1);
        for (Repair repair : repairList) {
            repair.setUser(userService.getById(repair.getStudentId()));
            repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
        }
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);
        return repairPageInfo;
    }

    @Override
    public PageInfo<Repair> getUndone(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        PageHelper.startPage(current, size);
        List<Repair> repairList = repairMapper.selectByRepairStatus(2);
        for (Repair repair : repairList) {
            repair.setUser(userService.getById(repair.getStudentId()));
            repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
            repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        }
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);
        return repairPageInfo;
    }

    @Override
    public PageInfo<Repair> getDone(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        PageHelper.startPage(current, size);
        List<Repair> repairList = repairMapper.selectByRepairStatus(3);
        for (Repair repair : repairList) {
            repair.setUser(userService.getById(repair.getStudentId()));
            repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
            repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        }
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);
        return repairPageInfo;
    }

    @Override
    public PageInfo<Repair> getAll(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        PageHelper.startPage(current, size);
        List<Repair> repairList = repairMapper.selectList(null);
        for (Repair repair : repairList) {
            repair.setUser(userService.getById(repair.getStudentId()));
            repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
            repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        }
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);
        return repairPageInfo;
    }

    @Override
    public Repair status(Integer userId) {
        Repair repair = repairMapper.selectByUserIdLimitOneStatus(userId);
        if (repair==null){
            repair = repairMapper.selectByUserIdLimitOne(userId);
        }
        repair.setUser(userService.getById(repair.getStudentId()));
        repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
        repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        return repair;
    }

    @Override
    public PageInfo<Repair> getStudentAll(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Integer userId = jsonObject.getInteger("userId");
        PageHelper.startPage(current, size);
        List<Repair> repairList = repairMapper.selectByStudentId(userId);
        for (Repair repair : repairList) {
            repair.setUser(userService.getById(repair.getStudentId()));
            repair.setRepairType(repairTypeService.getById(repair.getRepairTypeId()));
            repair.setRepairman(repairmanService.getById(repair.getRepairmanId()));
        }
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);
        return repairPageInfo;
    }
}
