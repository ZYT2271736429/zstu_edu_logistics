package com.zstu.edu.util;

/**
 * @author ThinkPad
 */

public enum ResultCode implements CustomizeResultCode {
    SUCCESS(200, "成功"),

    FAIL(500, "失败");

    private Integer code;

    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
