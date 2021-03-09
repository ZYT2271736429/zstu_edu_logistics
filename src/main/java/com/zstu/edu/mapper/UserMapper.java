package com.zstu.edu.mapper;

import com.zstu.edu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    User selectByUsername(String name);

    /**
     * 根据楼层id查找用户
     * @param roomsId
     * @return
     */
    List<User> selectListByRoomsId(Integer roomsId);

    /**
     * 通过学号或姓名搜索
     * @param search
     * @return
     */
    List<User> search(String search);

    /**
     * 退宿
     * @param id
     */
    void deleteDorm(Integer id);

    /**
     * 入住
     * @param username
     * @param dormId
     */
    void addDorm(@Param("username") String username,@Param("dormId") Integer dormId);

    /**
     * 更新密码
     * @param username
     * @param newpwd
     */
    void updatePassword(@Param("username") String username,@Param("newpwd") String newpwd);

    /**
     * 更新基本信息
     * @param username
     * @param phone
     * @param avatar
     */
    void updateInfo(@Param("username") String username,@Param("phone") String phone,@Param("avatar") String avatar);

    /**
     * 获得所有教职工
     * @return
     */
    List<User> selectNoStudent();
}
