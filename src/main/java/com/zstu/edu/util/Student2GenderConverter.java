package com.zstu.edu.util;

import com.github.crab2died.converter.ReadConvertible;

/**
 * 将男女转换为10
 */
public class Student2GenderConverter implements ReadConvertible {
    @Override
    public Object execRead(String object) {
        if ("男".equals(object)) {
            return 1;
        } else {
            return 0;
        }
    }
}
