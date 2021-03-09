package com.zstu.edu.service.impl;

import com.zstu.edu.entity.Repairman;
import com.zstu.edu.mapper.RepairmanMapper;
import com.zstu.edu.service.RepairmanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 维修员 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class RepairmanServiceImpl extends ServiceImpl<RepairmanMapper, Repairman> implements RepairmanService {

    @Autowired
    RepairmanMapper repairmanMapper;

    @Override
    public void add(Repairman repairman) {
        repairmanMapper.insert(repairman);
    }

    @Override
    public List<Repairman> getAll() {
        return repairmanMapper.selectList(null);
    }
}
