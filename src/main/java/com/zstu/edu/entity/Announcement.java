package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 校园公告
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布人id
     */
    private Integer facultyId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;

    /**
     * 审核是否通过
     */
    private Integer passedIf;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date passedTime;

    /**
     * 审核人id
     */
    private Integer passedFacultyId;

    /**
     * 是否删除
     */
    private Integer deleteIf;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 是否置顶
     */
    private Integer topIf;


}
