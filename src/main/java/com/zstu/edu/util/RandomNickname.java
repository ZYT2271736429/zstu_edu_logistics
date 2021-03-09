package com.zstu.edu.util;

import java.util.Random;

/**
 * 随机生成数字字符串
 * @author ThinkPad
 */
public class RandomNickname {
    private static String nickname;

    /**
     * 输入位数
     * @param length
     * @return
     */
    public static String getRandomNickname(int length) {
        String nickname = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nickname += String.valueOf(random.nextInt(10));
        }
        return nickname;
    }
}
