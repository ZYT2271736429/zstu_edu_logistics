package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author zyt
 * @since 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * url
     */
    private String url;

    /**
     * path
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 图标
     */
    private String iconCls;

    /**
     * 是否保持激活
     */
    private Integer keepAlive;

    /**
     * 是否要求权限
     */
    private Integer requireAuth;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 是否启用
     */
    private Integer enable;

    /*菜单*/
    private List<Menu> children;

}
