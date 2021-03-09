package com.zstu.edu.controller;

import com.zstu.edu.util.RandomNickname;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ThinkPad
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /*本地文件上传路径*/
    private static final String UPLOADED_FOLDER = "E:\\staticImages\\";

    //本地文件上传
    @RequestMapping("/upload")
    public String httpUpload(MultipartFile file) throws IOException {
        // 获取文件的后缀名
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //随机生成文件名
        String fileName = RandomNickname.getRandomNickname(10);
        System.out.println("文件后缀" + suffixName);
        System.out.println("执行了" + file.isEmpty() + file.getOriginalFilename() + "后缀" + suffixName);
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + fileName + suffixName);
        Files.write(path, bytes);
        System.out.println("文件名");
        System.out.println(fileName + suffixName);
        return fileName + suffixName;
    }
}
