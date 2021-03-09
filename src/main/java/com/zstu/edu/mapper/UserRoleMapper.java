package com.zstu.edu.mapper;

import com.zstu.edu.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    List<Integer> selectByUserId(Integer id);

    /**
     * 查询全部权限
     * @param userId
     * @param roleId
     * @return
     */
    List<UserRole> selectByCondition(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    /**
     * 删除用户权限
     * @param userId
     */
    void deleteByUserId(Integer userId);

    /**
     * 批量新增用户权限
     * @param userId
     * @param roleIdList
     */
    void insertUserRole(@Param("userId") Integer userId,@Param("roleIdList") List<Integer> roleIdList);
}
