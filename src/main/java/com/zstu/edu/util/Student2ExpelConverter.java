package com.zstu.edu.util;

import com.github.crab2died.converter.ReadConvertible;

/**
 * 将是否转换为01
 */
public class Student2ExpelConverter implements ReadConvertible {

    @Override
    public Object execRead(String object) {
        if ("是".equals(object)) {
            return 1;
        } else {
            return 0;
        }
    }
}
