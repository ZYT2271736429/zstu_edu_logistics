package com.zstu.edu.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author ThinkPad
 */
public class RandomName {
    /**
     * 汉字以两个字节存储，称为“区位码”，高位叫区码，低位叫位码，有这俩字节组成汉字
     * @return
     */
    private static char getRandomChar2() {
        String str = "";

        //随机数对象
        Random random = new Random();

        ///区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
        int hightPos = (176 + Math.abs(random.nextInt(39)));

        //位码，0xA0打头，范围第1~94列
        int lowPos = (161 + Math.abs(random.nextInt(93)));

        //字节码
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            //区位码组合成汉字
            str = new String(b, "GBK");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        //根据索引返回对应的字符
        return str.charAt(0);
    }
    public static String init() {
        /* 598 百家姓 */
        String[] names = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱"};

        //随机对象
        // Random r1 = new Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。
        //默认当前系统时间的毫秒数作为种子数:Random r1 = new Random();
        //说明：你在创建一个Random对象的时候可以给定任意一个合法的种子数，种子数只是随机算法的起源数字，和生成的随机数的区间没有任何关系。
        Random random = new Random(System.currentTimeMillis());

        //random.nextInt(597)中的597是随机数的上限,产生的随机数为0-597的整数,不包括597。
        int index = random.nextInt(names.length - 1);
//        System.out.println(index);

        //数组中的姓
        String name = names[index];

        //生成名字
        int i = ((int) (10 * Math.random())) % 2;
        if (1==0){
            name += getRandomChar2();
        }else {
            name += getRandomChar2();
            name += getRandomChar2();
        }

        return name;

    }
}
