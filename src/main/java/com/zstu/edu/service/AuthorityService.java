package com.zstu.edu.service;

import com.zstu.edu.entity.Authority;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface AuthorityService extends IService<Authority> {

    /**
     * 根据用户名获得权限
     * @param username
     * @return
     */
    List<Authority> getByUserName(String username);
}
