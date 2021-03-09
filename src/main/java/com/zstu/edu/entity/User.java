package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.crab2died.annotation.ExcelField;
import com.zstu.edu.util.Student2DateConverter;
import com.zstu.edu.util.Student2ExpelConverter;
import com.zstu.edu.util.Student2GenderConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    @ExcelField(title = "学号")
    private String username;

    /**
     * 用户密码-BCR算法加密
     */
    @ExcelField(title = "密码")
    private String password;

    /**
     * 姓名
     */
    @ExcelField(title = "姓名")
    private String name;

    /**
     * 性别
     */
    @ExcelField(title = "性别", readConverter = Student2GenderConverter.class)
    private Integer gender;

    /**
     * 手机号
     */
    @ExcelField(title = "手机号")
    private String phone;

    /**
     * 头像
     */
    @ExcelField(title = "头像")
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否为学生
     */
    @ExcelField(title = "是否为学生", readConverter = Student2ExpelConverter.class)
    private Integer studentIf;

    /**
     * 学院
     */
    @ExcelField(title = "学院")
    private String college;

    /**
     * 班级
     */
    @ExcelField(title = "班级")
    private String grade;

    /**
     * 专业
     */
    @ExcelField(title = "专业")
    private String profession;

    /**
     * 入学时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelField(title = "入学时间", readConverter = Student2DateConverter.class)
    private Date admissionTime;

    /**
     * 毕业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ExcelField(title = "毕业时间", readConverter = Student2DateConverter.class)
    private Date graduationTime;

    /**
     * 是否毕业
     */
    @ExcelField(title = "是否毕业", readConverter = Student2ExpelConverter.class)
    private Integer graduationIf;

    /**
     * 入住宿舍时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date roomTime;

    /**
     * 是否为教师
     */
    private Integer teacherIf;

    /**
     * 是否为职工
     */
    private Integer staffIf;

    /**
     * 职位
     */
    private String position;

    /**
     * 是否为管理员
     */
    private Integer administratorIf;

    /**
     * 无用字段
     */
    private Integer state;

    /**
     * 入住宿舍
     */
    private Integer roomId;

    /*宿舍*/
    @TableField(exist = false)
    private Rooms rooms;

    /*宿舍名称*/
    @TableField(exist = false)
    private Integer roomsName;

    /*楼层*/
    @TableField(exist = false)
    private Floors floors;

    /*楼层名称*/
    @TableField(exist = false)
    private Integer floorsName;

    /*宿舍楼*/
    @TableField(exist = false)
    private Buildings buildings;

    /*宿舍楼名称*/
    @TableField(exist = false)
    private String buildingsName;

}
