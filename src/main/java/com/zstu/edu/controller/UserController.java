package com.zstu.edu.controller;


import com.sun.org.apache.bcel.internal.generic.JSR;
import com.zstu.edu.entity.User;
import com.zstu.edu.service.UserService;
import com.zstu.edu.util.JsonResult;
import com.zstu.edu.util.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获得所有教职工
     * @return
     */
    @RequestMapping("getnostudent")
    public JsonResult getNoStudent(){
        List<User> userList=userService.getNoStudent();
        return JsonResult.ok().data("userList",userList);
    }

    /**
     *更新基本信息
     * @param username
     * @param phone
     * @param avatar
     * @return
     */
    @RequestMapping("updateinfo")
    public JsonResult updateInfo(@RequestParam String username,@RequestParam String phone,@RequestParam String avatar){
        userService.updateInfo(username,phone,avatar);
        return JsonResult.ok();
    }

    /**
     * 修改密码
     *
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @RequestMapping("updatepassword")
    public JsonResult updatePassword(@RequestParam String username, @RequestParam String oldpwd,
                                     @RequestParam String newpwd) throws Exception {
        Boolean aboolean = userService.updatePassword(username, oldpwd, newpwd);
        return JsonResult.ok().data("successIf", aboolean);
    }

    /**
     * 通过学号或姓名搜索
     *
     * @param search
     * @return
     */
    @RequestMapping("search")
    public JsonResult search(@RequestParam(required = false) String search) {
        ArrayList<User> userList = new ArrayList<>();
        if (!search.equals("")) {
            userList = (ArrayList<User>) userService.search(search);
        }
        return JsonResult.ok().data("userList", userList);
    }

    /**
     * 通过id查找用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("getuserinfobyid")
    public JsonResult getUserInfoById(@RequestParam(required = false) Integer id) {
        User user = userService.getUserInfoById(id);
        return JsonResult.ok().data("user", user);
    }

    /**
     * 通过学号查找用户信息
     *
     * @param username
     * @return
     */
    @RequestMapping("getuserinfobyusername")
    public JsonResult getUserInfoByUsername(@RequestParam(required = false) String username) {
        User user = userService.getUserInfoByUsername(username);
        return JsonResult.ok().data("user", user);
    }

    /**
     * 获得宿舍成员
     *
     * @param roomsId
     * @return
     */
    @RequestMapping("getbyroomsid")
    public JsonResult getByRoomsId(@RequestParam(required = false) Integer roomsId) {
        List<User> userList = userService.getListByRoomsId(roomsId);
        return JsonResult.ok().data("userList", userList);
    }

    /**
     * 入住
     *
     * @param username
     * @param dormId
     * @return
     */
    @RequestMapping("adddorm")
    public JsonResult addDorm(@RequestParam String username, @RequestParam Integer dormId) {
        userService.addDorm(username, dormId);
        return JsonResult.ok();
    }

    /**
     * 退宿
     *
     * @param id
     * @return
     */
    @RequestMapping("deletedorm")
    public JsonResult deleteDorm(@RequestBody Integer id) {
        userService.deleteDorm(id);
        return JsonResult.ok();
    }

    /**
     * 添加用户、用户自行注册。
     * * @return
     */
    @PostMapping("register")
    public JsonResult register() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = "2017329621184";
        // 注册超级管理员
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setName("周云挺");
        user.setGender(0);
        user.setPhone("13777888940");
        user.setAvatar("https://www.google.com/imgres?imgurl=http%3A%2F%2Fimg.wxcha.com%2Fm00%2Fbd%2F2b%2F9db580058cb3ca3c8d74e885f9cffe78.jpg&imgrefurl=http%3A%2F%2Fwww.wxcha.com%2Ftouxiang%2Ft%2Fdongman%2F&tbnid=E_q3_7mKvX2h8M&vet=12ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ..i&docid=flZ1m4lIv1082M&w=690&h=690&q=%E5%8A%A8%E6%BC%AB%E5%A4%B4%E5%83%8F&ved=2ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ");
        user.setCollege("信息学院");
        user.setProfession("计算机科学与技术");
        user.setTeacherIf(1);
        user.setAdministratorIf(1);
        user.setAdmissionTime(dateFormat.parse("2017-09-01"));
        user.setGraduationTime(dateFormat.parse("2021-09-01"));
        try {
            userService.register(user);
            return JsonResult.ok();
        } catch (Exception e) {
            return JsonResult.fail();
//            return JsonResult.failed(e.getMessage());
        }
    }

    @PostMapping("register2")
    public JsonResult register2() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = "2017329621185";
        // 注册学生
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setName("朱博伦");
        user.setGender(0);
        user.setPhone("13777888940");
        user.setAvatar("https://www.google.com/imgres?imgurl=http%3A%2F%2Fimg.wxcha.com%2Fm00%2Fbd%2F2b%2F9db580058cb3ca3c8d74e885f9cffe78.jpg&imgrefurl=http%3A%2F%2Fwww.wxcha.com%2Ftouxiang%2Ft%2Fdongman%2F&tbnid=E_q3_7mKvX2h8M&vet=12ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ..i&docid=flZ1m4lIv1082M&w=690&h=690&q=%E5%8A%A8%E6%BC%AB%E5%A4%B4%E5%83%8F&ved=2ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ");
        user.setCollege("信息学院");
        user.setProfession("计算机科学与技术");
        user.setTeacherIf(1);
        user.setAdministratorIf(0);
        user.setAdmissionTime(dateFormat.parse("2017-09-01"));
        user.setGraduationTime(dateFormat.parse("2021-09-01"));
        try {
            userService.register(user);
            return JsonResult.ok();
        } catch (Exception e) {
            return JsonResult.fail();
//            return JsonResult.failed(e.getMessage());
        }
    }

    @PostMapping("register3")
    public JsonResult register3() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = "2017329621186";
        // 注册学生
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setName("杜开印");
        user.setGender(0);
        user.setPhone("13777888940");
        user.setAvatar("https://www.google.com/imgres?imgurl=http%3A%2F%2Fimg.wxcha.com%2Fm00%2Fbd%2F2b%2F9db580058cb3ca3c8d74e885f9cffe78.jpg&imgrefurl=http%3A%2F%2Fwww.wxcha.com%2Ftouxiang%2Ft%2Fdongman%2F&tbnid=E_q3_7mKvX2h8M&vet=12ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ..i&docid=flZ1m4lIv1082M&w=690&h=690&q=%E5%8A%A8%E6%BC%AB%E5%A4%B4%E5%83%8F&ved=2ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ");
        user.setCollege("信息学院");
        user.setProfession("计算机科学与技术");
        user.setTeacherIf(1);
        user.setAdministratorIf(0);
        user.setAdmissionTime(dateFormat.parse("2017-09-01"));
        user.setGraduationTime(dateFormat.parse("2021-09-01"));
        try {
            userService.register(user);
            return JsonResult.ok();
        } catch (Exception e) {
            return JsonResult.fail();
//            return JsonResult.failed(e.getMessage());
        }
    }

    @PostMapping("registerall")
    public JsonResult registerAll() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = "2017329621184";
        // 注册学生
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setName(RandomName.init());
        if (((int) (10 * Math.random())) % 2 == 0) {
            user.setGender(0);
        } else {
            user.setGender(1);
        }
        user.setPhone("13777888940");
        user.setAvatar("https://www.google.com/imgres?imgurl=http%3A%2F%2Fimg.wxcha.com%2Fm00%2Fbd%2F2b%2F9db580058cb3ca3c8d74e885f9cffe78.jpg&imgrefurl=http%3A%2F%2Fwww.wxcha.com%2Ftouxiang%2Ft%2Fdongman%2F&tbnid=E_q3_7mKvX2h8M&vet=12ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ..i&docid=flZ1m4lIv1082M&w=690&h=690&q=%E5%8A%A8%E6%BC%AB%E5%A4%B4%E5%83%8F&ved=2ahUKEwie6r7fofvuAhWaEKYKHRuzBf4QMygAegUIARCOAQ");
        user.setStudentIf(1);
        user.setCollege("信息学院");
        user.setProfession("计算机科学与技术");
        user.setGrade("3");
        user.setAdmissionTime(dateFormat.parse("2017-09-01"));
        user.setGraduationTime(dateFormat.parse("2021-09-01"));
        user.setGraduationIf(0);
        //插入 信息学院 **专业 *＊班级
        for (int i = 0; i < 13; i++) {
            username = String.valueOf(Integer.valueOf(username) + 1);

        }

        return JsonResult.ok();
    }
}
