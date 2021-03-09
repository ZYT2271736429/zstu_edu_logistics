package com.zstu.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Role;
import com.zstu.edu.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    List<Role> getByUserId(Integer id);

    /**
     * 查询全部权限
     * @return
     */
    PageInfo<UserRole> getByCondition(String queryCondition);

    /**
     * 取消权限
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增权限
     * @param condition
     */
    void add(String condition);
}
