package com.zstu.edu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 档口级联选择
 *
 * @author ThinkPad
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StallVO implements Serializable {
    /*档口id*/
    private Integer value;

    /*档口名称*/
    private String label;

    /*档口*/
    private List<StallVO> children;
}
