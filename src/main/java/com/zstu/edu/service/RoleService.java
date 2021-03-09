package com.zstu.edu.service;

import com.zstu.edu.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id查找角色
     * @param id
     * @return
     */
    List<Role> getByUserId(Integer id);

    /**
     * 根据用户id查找角色id
     * @param id
     * @return
     */
    List<Integer> getRoleIdByUserId(Integer id);

    /**
     * 根据id批量查找角色
     * @param roleIdList
     * @return
     */
    List<Role> getListByUserId(List<Integer> roleIdList);

    /**
     * 查询全部角色
     * @return
     */
    List<Role> getAll();
}
