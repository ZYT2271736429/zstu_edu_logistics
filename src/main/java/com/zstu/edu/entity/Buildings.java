package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 宿舍楼
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Buildings implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 楼宇名称
     */
    private String name;

    /**
     * 楼层数
     */
    private Integer floorCount;

    /**
     * 每层楼房间数
     */
    private Integer roomCount;

    /*学生数*/
    @TableField(exist = false)
    private Integer studentCount;
}
