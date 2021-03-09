package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Authority;
import com.zstu.edu.entity.Role;
import com.zstu.edu.entity.User;
import com.zstu.edu.mapper.AuthorityMapper;
import com.zstu.edu.service.AuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zstu.edu.service.UserRoleService;
import com.zstu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public List<Authority> getByUserName(String username) {
        User user = userService.getByUsername(username);
        List<Role> roleList = userRoleService.getByUserId(user.getId());
        return authorityMapper.getByRoleId(roleList);
    }
}
