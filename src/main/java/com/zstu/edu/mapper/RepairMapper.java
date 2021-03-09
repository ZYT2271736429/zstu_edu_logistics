package com.zstu.edu.mapper;

import com.zstu.edu.entity.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 网上保修 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Repository
public interface RepairMapper extends BaseMapper<Repair> {

    /**
     * 待处理
     * @return
     */
    List<Repair> selectByRepairStatus(Integer id);

    /**
     * 根据报修人id获得报修进度
     * @param userId
     * @return
     */
    Repair selectByUserIdLimitOne(Integer userId);

    /**
     * 报修人的报修历史
     * @param userId
     * @return
     */
    List<Repair> selectByStudentId(Integer userId);

    /**
     * 报修人的报修历史
     * @param userId
     * @return
     */
    Repair selectByUserIdLimitOneStatus(Integer userId);
}
