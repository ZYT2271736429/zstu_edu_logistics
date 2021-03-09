package com.zstu.edu.mapper;

import com.zstu.edu.entity.Buy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 申购 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2021-02-27
 */
@Repository
public interface BuyMapper extends BaseMapper<Buy> {

    /**
     * 根据条件查询
     *
     * @param status
     * @return
     */
    List<Buy> selectByCondition(@Param("status") Boolean status, @Param("statusIfOne") Boolean statusIfOne);
}
