package com.zstu.edu.util;

/**
 * @author ThinkPad
 */
public interface CustomizeResultCode {

    /**
     * 获取错误状态码
     * @return
     */
    Integer getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getMsg();
}
