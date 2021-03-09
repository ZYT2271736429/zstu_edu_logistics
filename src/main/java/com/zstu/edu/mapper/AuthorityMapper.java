package com.zstu.edu.mapper;

import com.zstu.edu.entity.Authority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zstu.edu.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 根据角色id查询权限
     * @param roleList
     * @return
     */
    List<Authority> getByRoleId(List<Role> roleList);
}
