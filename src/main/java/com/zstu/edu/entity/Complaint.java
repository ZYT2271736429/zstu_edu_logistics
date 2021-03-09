package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 投诉
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片
     */
    private String photo;

    /**
     * 投诉时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date complaintTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 处理
     */
    private String deal;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealTime;

    /**
     * 处理人id
     */
    private Integer userId;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 档口id
     */
    private Integer stallId;

    /*档口*/
    @TableField(exist = false)
    private Stall stall;

    /*处理人*/
    @TableField(exist = false)
    private User user;

}
