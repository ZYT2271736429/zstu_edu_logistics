package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜品
 * </p>
 *
 * @author zyt
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dishes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 图片
     */
    private String photo;

    /**
     * 评分
     */
    private Double score;

    /**
     * 档口id
     */
    private Integer stallId;


}
