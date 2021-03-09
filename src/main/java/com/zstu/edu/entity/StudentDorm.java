package com.zstu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentDorm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 宿舍id
     */
    private Integer dormId;

    /**
     * 是否入住
     */
    private Integer emptyIf;

    /**
     * 入住时间
     */
    private LocalDateTime stayInTime;

    /**
     * 退宿时间
     */
    private LocalDateTime checkOutTime;


}
