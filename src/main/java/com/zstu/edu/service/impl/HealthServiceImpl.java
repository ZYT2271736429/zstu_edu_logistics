package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Health;
import com.zstu.edu.mapper.HealthMapper;
import com.zstu.edu.service.HealthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 卫生状况 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Service
public class HealthServiceImpl extends ServiceImpl<HealthMapper, Health> implements HealthService {

}
