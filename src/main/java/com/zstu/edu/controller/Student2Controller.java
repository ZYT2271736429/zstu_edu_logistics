package com.zstu.edu.controller;

import com.github.crab2died.ExcelUtils;
import com.zstu.edu.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/student2Controller")
public class Student2Controller {

    @RequestMapping("get")
    public String get(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("执11111111111行");
        InputStream inputStream = file.getInputStream();
        List<User> list = ExcelUtils.getInstance().readCSV2Objects(inputStream, User.class);
        System.out.println(list);
        return "你好";
    }
}
