package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 宿舍
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dorm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 楼号
     */
    private String floor;

    /**
     * 层号
     */
    private String layer;

    /**
     * 宿舍号
     */
    private String dormitory;

    /**
     * 床总数
     */
    private Integer bedNumber;

    /**
     * 床号
     */
    private String bed;

    /**
     * 是否为空
     */
    private String emptyIf;


}
