package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Student;
import com.zstu.edu.mapper.StudentMapper;
import com.zstu.edu.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
