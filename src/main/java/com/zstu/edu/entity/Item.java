package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 申购清单
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物品id
     */
    private Integer productId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 申购id
     */
    private Integer buyId;

    /*物品*/
    @TableField(exist = false)
    private Product product;


}
