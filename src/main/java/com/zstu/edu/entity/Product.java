package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 物品
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

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
     * 描述
     */
    private String description;

    /**
     * 总量
     */
    private Integer total;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 物品类型id
     */
    private Integer productTypeId;

    /*物品类型*/
    @TableField(exist = false)
    private ProductType productType;
}
