package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Product;
import com.zstu.edu.entity.Role;
import com.zstu.edu.entity.UserRole;
import com.zstu.edu.mapper.UserRoleMapper;
import com.zstu.edu.service.RoleService;
import com.zstu.edu.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public List<Role> getByUserId(Integer id) {
        List<Integer> roleIdList = userRoleMapper.selectByUserId(id);
        return roleService.getListByUserId(roleIdList);
    }

    @Override
    public PageInfo<UserRole> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Integer userId = jsonObject.getInteger("userId");
        Integer roleId = jsonObject.getInteger("roleId");

        PageHelper.startPage(current, size);

        List<UserRole> userRoleList = userRoleMapper.selectByCondition(userId, roleId);
        for (UserRole userRole : userRoleList) {
            userRole.setUser(userService.getById(userRole.getUserId()));
            userRole.setRole(roleService.getById(userRole.getRoleId()));
        }

        PageInfo<UserRole> userRolePageInfo = new PageInfo<>(userRoleList);
        return userRolePageInfo;
    }

    @Override
    public void deleteById(Integer id) {
        userRoleMapper.deleteById(id);
    }

    @Override
    public void add(String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer userId = jsonObject.getInteger("userId");
        String roleIds = jsonObject.getString("roleIdList");
        List<Integer> roleIdList = JSONObject.parseArray(roleIds, Integer.class);
        userRoleMapper.deleteByUserId(userId);
        userRoleMapper.insertUserRole(userId,roleIdList);
    }
}
