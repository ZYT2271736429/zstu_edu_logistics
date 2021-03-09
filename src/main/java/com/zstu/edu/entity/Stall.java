package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 档口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Stall implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 档口
     */
    private String name;

    /**
     * 负责人
     */
    private String head;

    /**
     * 负责人电话
     */
    private String phone;

    /**
     * 图片
     */
    private String photo;

    /**
     * 采集时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date collectionTime;

    /**
     * 卫生图片
     */
    private String healthPhoto;

    /**
     * 卫生评分
     */
    private Double healthScore;

    /**
     * 满意度评分
     */
    private Double feedbackScore;

    /**
     * 食堂id
     */
    private Integer canteenId;

    /*食堂*/
    @TableField(exist = false)
    private Canteen canteen;

    /*菜品*/
    @TableField(exist = false)
    private List<Dishes> dishesList;
}
