package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 申购
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 申购时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buyTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 总价
     */
    private Double price;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date completeTime;

    /**
     * 申购人id
     */
    private Integer facultyBuyId;

    /**
     * 处理人id
     */
    private Integer facultyDealId;

    /*清单列表*/
    @TableField(exist = false)
    private List<Item> itemList;

    /*申购人*/
    @TableField(exist = false)
    private User facultyBuy;

    /*处理人*/
    @TableField(exist = false)
    private User facultyDeal;
}
