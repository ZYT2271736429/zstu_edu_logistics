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
 * 反馈
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 反馈档口id
     */
    private Integer stallId;

    /**
     * 反馈菜品id
     */
    private Integer dishesId;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 反馈
     */
    private String feedback;

    /**
     * 图片
     */
    private String photo;

    /**
     * 反馈时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date feedbackTime;

    /**
     * 学生id
     */
    private Integer studentId;

    /*档口*/
    @TableField(exist = false)
    private Stall stall;

    /*菜品*/
    @TableField(exist = false)
    private Dishes dishes;

    /*反馈人*/
    @TableField(exist = false)
    private User user;
}
