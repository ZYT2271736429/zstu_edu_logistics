package com.zstu.edu.service;

import com.zstu.edu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查找用户信息
     *
     * @param name
     * @return
     */
    User getByUsername(String name);

    /**
     * 登录
     *
     * @param username
     * @param rawPassword
     * @return
     */
    boolean checkLogin(String username, String rawPassword) throws Exception;

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean register(User user) throws Exception;

    /**
     * 根据宿舍获得用户
     *
     * @param roomsId
     * @return
     */
    List<User> getListByRoomsId(Integer roomsId);

    /**
     * 通过学号或姓名搜索
     *
     * @param search
     * @return
     */
    List<User> search(String search);

    /**
     * 通过学号查找用户信息
     *
     * @param username
     * @return
     */
    User getUserInfoByUsername(String username);

    /**
     * 通过id查找用户信息
     *
     * @param id
     * @return
     */
    User getUserInfoById(Integer id);

    /**
     * 退宿
     *
     * @param id
     */
    void deleteDorm(Integer id);

    /**
     * 入住
     *
     * @param username
     * @param dormId
     */
    void addDorm(String username, Integer dormId);

    /**
     * 修改密码
     *
     * @param username
     * @param oldpwd
     * @param newpwd
     * @return
     */
    Boolean updatePassword(String username,String oldpwd, String newpwd) throws Exception;

    /**
     * 更新基本信息
     * @param username
     * @param phone
     * @param avatar
     */
    void updateInfo(String username, String phone, String avatar);

    /**
     * 获得所有教职工
     * @return
     */
    List<User> getNoStudent();
}
