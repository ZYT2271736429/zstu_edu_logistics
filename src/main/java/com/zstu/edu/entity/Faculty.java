package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教职工
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Faculty implements Serializable {

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
     * 是否为教师
     */
    private Integer teacherIf;

    /**
     * 教师编号
     */
    private String teacherId;

    /**
     * 是否为职工
     */
    private Integer staffIf;

    /**
     * 职工编号
     */
    private String staffId;

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
     * 职位
     */
    private String position;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否为管理员
     */
    private Integer administratorIf;

    /**
     * 用户角色表id
     */
    private Integer userRoleId;


}
