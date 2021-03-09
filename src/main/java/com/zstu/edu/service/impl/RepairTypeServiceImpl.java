package com.zstu.edu.service.impl;

import com.zstu.edu.entity.RepairType;
import com.zstu.edu.mapper.RepairTypeMapper;
import com.zstu.edu.mapper.RepairmanMapper;
import com.zstu.edu.service.RepairTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 故障类型 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class RepairTypeServiceImpl extends ServiceImpl<RepairTypeMapper, RepairType> implements RepairTypeService {

    @Autowired
    RepairTypeMapper repairTypeMapper;

    @Override
    public void add(RepairType repairType) {
        repairTypeMapper.insert(repairType);
    }

    @Override
    public List<RepairType> getAll() {
        return repairTypeMapper.selectList(null);
    }
}
