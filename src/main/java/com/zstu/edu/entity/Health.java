package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 卫生状况
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Health implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片
     */
    private String image;

    /**
     * 采集时间
     */
    private String collectionTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 档口id
     */
    private Integer stallId;


}
