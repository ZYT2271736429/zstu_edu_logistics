package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码-BCR算法加密
     */
    private String password;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 学院
     */
    private String college;

    /**
     * 班级
     */
    private String grade;

    /**
     * 专业
     */
    private String profession;

    /**
     * 入学时间
     */
    private LocalDateTime admissionTime;

    /**
     * 毕业时间
     */
    private LocalDateTime graduationTime;

    /**
     * 是否毕业
     */
    private Integer graduationIf;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户角色表id
     */
    private Integer userRoleId;


}
