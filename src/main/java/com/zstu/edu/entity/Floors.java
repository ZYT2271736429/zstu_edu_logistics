package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 楼层
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Floors implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 楼层
     */
    private Integer layer;

    /**
     * 宿舍楼id
     */
    private Integer buildingId;

    /*宿舍*/
    @TableField(exist = false)
    private List<Rooms> roomsList;

}
