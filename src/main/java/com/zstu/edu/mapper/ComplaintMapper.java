package com.zstu.edu.mapper;

import com.zstu.edu.entity.Complaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 投诉 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Repository
public interface ComplaintMapper extends BaseMapper<Complaint> {

    /**
     * 按条件查询他投诉记录
     * @param userId
     * @param status
     * @return
     */
    List<Complaint> selectByCondition(@Param("userId") Integer userId,@Param("status") Integer status);
}
