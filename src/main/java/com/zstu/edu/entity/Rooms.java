package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 房间
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房间号
     */
    private Integer number;

    /**
     * 宿舍状态，可入住为1，不可入住为2
     */
    private Integer status;

    /**
     * 房间最大人数
     */
    @TableField("peopleNum")
    private Integer peoplenum;

    /**
     * 宿舍楼id
     */
    private Integer buildingId;

    /**
     * 楼层id
     */
    private Integer floorsId;

    /*宿舍楼*/
    @TableField(exist = false)
    private Buildings buildings;

    /*宿舍楼名称*/
    @TableField(exist = false)
    private String buildingsName;

    /*楼层*/
    @TableField(exist = false)
    private Floors floors;

    /*楼层名称*/
    @TableField(exist = false)
    private Integer floorsName;

    /*学生*/
    @TableField(exist = false)
    private List<User> userList;

}
