package com.zstu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ThinkPad
 */
@SpringBootApplication
@MapperScan("com.zstu.edu.mapper")
public class LogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
    }

}
