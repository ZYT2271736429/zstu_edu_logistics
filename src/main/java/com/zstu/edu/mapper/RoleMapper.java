package com.zstu.edu.mapper;

import com.zstu.edu.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 角色id批量查询角色
     * @param roleIdList
     * @return
     */
    List<Role> selectListById(List<Integer> roleIdList);

    /**
     * 用户id查询角色
     * @param id
     * @return
     */
    List<Role> selectByUserId(Integer id);

    /**
     * 用户id查询角色id
     * @param id
     * @return
     */
    List<Integer> selectRoleIdByUserId(Integer id);

    /**
     * 根据角色查询
     * @param role
     * @return
     */
    List<Role> getByRole(String role);

    /**
     * 查询全部角色
     * @return
     */
    List<Role> selectAll();
}
