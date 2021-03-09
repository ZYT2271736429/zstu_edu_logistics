package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 网上保修
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 维修单号
     */
    private String orderN;

    /**
     * 报修时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date reservationTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 照片
     */
    private String photo;

    /**
     * 报修楼
     */
    private String floor;

    /**
     * 报修宿舍
     */
    private String dormitory;

    /**
     * 维修时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date repairTime;

    /**
     * 维修结果
     */
    private String result;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 维修反馈
     */
    private String feedback;

    /**
     * 报修人id
     */
    private Integer studentId;

    /**
     * 故障类型id
     */
    private Integer repairTypeId;

    /**
     * 报修状态id
     */
    private Integer repairStatus;

    /**
     * 维修员id
     */
    private Integer repairmanId;

    /*报修人*/
    @TableField(exist = false)
    private User user;

    /*故障类型*/
    @TableField(exist = false)
    private RepairType repairType;

    /*维修员*/
    @TableField(exist = false)
    private Repairman repairman;
}
