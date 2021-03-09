package com.zstu.edu.service.impl;

import com.zstu.edu.components.BCryptPasswordEncoderUtil;
import com.zstu.edu.entity.Buildings;
import com.zstu.edu.entity.Floors;
import com.zstu.edu.entity.Rooms;
import com.zstu.edu.entity.User;
import com.zstu.edu.mapper.UserMapper;
import com.zstu.edu.service.BuildingsService;
import com.zstu.edu.service.FloorsService;
import com.zstu.edu.service.RoomsService;
import com.zstu.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //用户激活状态
    private static final int USER_STATE = 1;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    @Autowired
    RoomsService roomsService;

    @Autowired
    FloorsService floorsService;

    @Autowired
    BuildingsService buildingsService;

    @Override
    public User getByUsername(String name) {
        User user = userMapper.selectByUsername(name);
        if (user.getRoomId() != null) {
            Rooms roomInfo = roomsService.getRoomInfo(user.getRoomId());
            user.setBuildingsName(roomInfo.getBuildingsName());
            user.setFloorsName(roomInfo.getFloorsName());
            user.setRoomsName(roomInfo.getNumber());
        }
        return user;
    }

    @Override
    public boolean checkLogin(String username, String rawPassword) throws Exception {
        log.warn("执行 检测账号密码是否存在");
        User user = getByUsername(username);
        System.out.println("111111111111111111111");
        System.out.println("userEntity = " + user);
        if (user == null) {
            System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            //设置友好提示
            throw new Exception("账号不存在，请重新尝试！");
        } else {
            //加密的密码
            String encodedPassword = user.getPassword();
            //和加密后的密码进行比配
            if (!bCryptPasswordEncoderUtil.matches(rawPassword, encodedPassword)) {
                //System.out.println("checkLogin--------->密码不正确！");
                //设置友好提示
                System.out.println("checkLogin--------->密码不正确！");
                throw new Exception("密码不正确！");
            } else {
                System.out.println("checkLogin--------->密码正确");
                return true;
            }
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean register(User user) throws Exception {
        if (user != null) {
            User f = getByUsername(user.getUsername());
            if (f != null) {
                throw new Exception("这个用户已经存在，不能重复。");
            }
            //对密码进行加密
            user.setPassword(bCryptPasswordEncoderUtil.encode(user.getPassword()));
            //设置状态为1
            user.setState(USER_STATE);
            //保存到数据库
            user.setAvatar(null);
            userMapper.insert(user);
            return true;
        } else {
            throw new Exception("错误消息：用户对象为空！");
        }
    }

    @Override
    public List<User> getListByRoomsId(Integer roomsId) {
        List<User> userList = userMapper.selectListByRoomsId(roomsId);
        for (User user : userList) {
            Rooms rooms = roomsService.getById(user.getRoomId());
            user.setRooms(rooms);
            user.setRoomsName(rooms.getNumber());
            Floors floors = floorsService.getById(rooms.getFloorsId());
            user.setFloors(floors);
            user.setFloorsName(floors.getLayer());
            Buildings buildings = buildingsService.getById(floors.getBuildingId());
            user.setBuildings(buildings);
            user.setBuildingsName(buildings.getName());
        }
        return userList;
    }

    @Override
    public List<User> search(String search) {
        return userMapper.search(search);
    }

    @Override
    public User getUserInfoByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user.getRoomId() != null) {
            Rooms rooms = roomsService.getById(user.getRoomId());
            user.setRooms(rooms);
            user.setRoomsName(rooms.getNumber());
            Floors floors = floorsService.getById(rooms.getFloorsId());
            user.setFloors(floors);
            user.setFloorsName(floors.getLayer());
            Buildings buildings = buildingsService.getById(floors.getBuildingId());
            user.setBuildings(buildings);
            user.setBuildingsName(buildings.getName());
        }
        return user;
    }

    @Override
    public User getUserInfoById(Integer id) {
        User user = userMapper.selectById(id);
        Rooms rooms = roomsService.getById(user.getRoomId());
        user.setRooms(rooms);
        Floors floors = floorsService.getById(rooms.getFloorsId());
        user.setFloors(floors);
        Buildings buildings = buildingsService.getById(floors.getBuildingId());
        user.setBuildings(buildings);
        return user;
    }

    @Override
    public void deleteDorm(Integer id) {
        userMapper.deleteDorm(id);
    }

    @Override
    public void addDorm(String username, Integer dormId) {
        userMapper.addDorm(username, dormId);
    }

    @Override
    public Boolean updatePassword(String username, String oldpwd, String newpwd) throws Exception {
        User user = getByUsername(username);
        //加密的密码
        String encodedPassword = user.getPassword();
        //和加密后的密码进行比配
        if (!bCryptPasswordEncoderUtil.matches(oldpwd, encodedPassword)) {
            //设置友好提示
            throw new Exception("密码不正确！");
        } else {
            newpwd = bCryptPasswordEncoderUtil.encode(newpwd);
            userMapper.updatePassword(username, newpwd);
            return true;
        }
    }

    @Override
    public void updateInfo(String username, String phone, String avatar) {
        userMapper.updateInfo(username, phone, avatar);
    }

    @Override
    public List<User> getNoStudent() {
        return userMapper.selectNoStudent();
    }

}
