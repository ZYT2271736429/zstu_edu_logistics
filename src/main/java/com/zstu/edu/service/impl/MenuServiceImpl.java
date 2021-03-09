package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Menu;
import com.zstu.edu.mapper.MenuMapper;
import com.zstu.edu.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleService roleService;

    @Override
    public List<Menu> getByUserId(Integer id) {
        List<Integer> roleIdList = roleService.getRoleIdByUserId(id);
        List<Integer> menuIdList = menuMapper.selectMenuIdListByRoleId(roleIdList);
        List<Menu> menuList = menuMapper.selectByMenuId(menuIdList);
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getParentId() != null && menu.getParentId() == 1) {
                menuArrayList.add(menu);
            }
        }
        for (Menu menu : menuArrayList) {
            ArrayList<Menu> menus = new ArrayList<>();
            for (Menu menu1 : menuList) {
                if (menu1.getParentId() != null && menu.getId() != null) {
                    if (menu1.getParentId().equals(menu.getId())) {
                        menus.add(menu1);
                    }
                }
            }
            menu.setChildren(menus);
        }
        return menuArrayList;
    }
}
