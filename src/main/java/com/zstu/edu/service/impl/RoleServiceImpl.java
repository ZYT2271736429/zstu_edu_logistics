package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zstu.edu.entity.Role;
import com.zstu.edu.mapper.RoleMapper;
import com.zstu.edu.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.UserRoleService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getByUserId(Integer id) {
        return roleMapper.selectByUserId(id);
    }

    @Override
    public List<Integer> getRoleIdByUserId(Integer id) {
        return roleMapper.selectRoleIdByUserId(id);
    }


    @Override
    public List<Role> getListByUserId(List<Integer> roleIdList) {
        return roleMapper.selectListById(roleIdList);
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.selectAll();
    }
}
