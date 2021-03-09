package com.zstu.edu.mapper;

import com.zstu.edu.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-19
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 菜单id获得菜单
     * @param menuIdList
     * @return
     */
    List<Menu> selectByMenuId(List<Integer> menuIdList);

    /**
     * 角色id获得菜单id
     * @param roleIdList
     * @return
     */
    List<Integer> selectMenuIdListByRoleId(List<Integer> roleIdList);
}
