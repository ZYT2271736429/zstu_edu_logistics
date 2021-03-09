package com.zstu.edu.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共返回结果
 *
 * @author ThinkPad
 */
@Data
public class JsonResult {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造方法私有化,里面的方法都是静态方法
     * 达到保护属性的作用
     */
    private JsonResult() {

    }

    /**
     * 这里使用链式编程
     */
    public static JsonResult ok() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setCode(ResultCode.SUCCESS.getCode());
        jsonResult.setMsg(ResultCode.SUCCESS.getMsg());
        return jsonResult;
    }

    /**
     * 这里使用链式编程
     */
    public static JsonResult fail() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setCode(ResultCode.FAIL.getCode());
        jsonResult.setMsg(ResultCode.FAIL.getMsg());
        return jsonResult;
    }

    /**
     * 自定义返回成功与否
     *
     * @param success
     * @return
     */
   /* public JsonResult success(Boolean success) {
        this.setSuccess(success);
        return this;
    }*/

    /**
     * 自定义返回消息
     *
     * @param msg
     * @return
     */
 /*   public JsonResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }*/

    /**
     * 自定义返回状态码
     * @param code
     * @return
     */
   /* public JsonResult code(Integer code) {
        this.setCode(code);
        return this;
    }*/

    /**
     * 自定义返回数据
     *
     * @param key
     * @param value
     * @return
     */
    public JsonResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 自定义返回数据
     *
     * @param map
     * @return
     */
    public JsonResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
