package com.zstu.edu.service.auth;

import com.zstu.edu.entity.Role;
import com.zstu.edu.entity.User;
import com.zstu.edu.service.UserRoleService;
import com.zstu.edu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 要实现UserDetailsService接口，这个接口是security提供的
 *
 * @author ThinkPad
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(AuthUserDetailsServiceImpl.class);


    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    /**
     * 通过账号查找用户、角色的信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.warn("实现自定义的UserDetails, 通过账号查找用户角色信息");
        User user = userService.getByUsername(username);
        if (user == null) {
            log.warn("用户不存在");
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        } else {
            log.warn("用户存在,开始查找角色");
            //查找角色
            List<Role> roles = userRoleService.getByUserId(user.getId());
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
            log.warn("查询出角色信息: " + user + ".............." + authorities);
            System.out.println("loadUserByUsername......user ===> " + user);
            return new AuthUser(user.getUsername(), user.getPassword(), user.getState(), authorities);
        }
    }
}
