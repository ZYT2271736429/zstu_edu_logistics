package com.zstu.edu.util;

import com.github.crab2died.converter.ReadConvertible;
import com.github.crab2died.utils.DateUtils;

/**
 * 读取excel日期数据转换器
 */
public class Student2DateConverter implements ReadConvertible {

    @Override
    public Object execRead(String object) {
        return DateUtils.str2Date(object, "yyyy/MM/dd");
    }
}
