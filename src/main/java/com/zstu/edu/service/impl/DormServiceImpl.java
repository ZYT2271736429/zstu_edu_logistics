package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Dorm;
import com.zstu.edu.mapper.DormMapper;
import com.zstu.edu.service.DormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 宿舍 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {

    @Autowired
    DormMapper dormMapper;

    @Override
    public void add(Dorm dorm) {
        dormMapper.insert(dorm);
    }

    @Override
    public List<String> getFloor() {
        return dormMapper.getFloor();
    }

    @Override
    public List<String> getDormitory() {
        return dormMapper.getDormitory();
    }
}
