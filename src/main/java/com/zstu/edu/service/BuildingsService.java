package com.zstu.edu.service;

import com.zstu.edu.entity.Buildings;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宿舍楼 服务类
 * </p>
 *
 * @author zyt
 * @since 2021-02-28
 */
public interface BuildingsService extends IService<Buildings> {

    /**
     * 获取全部宿舍楼
     * @return
     */
    List<Buildings> getAll();

    /**
     * 获取宿舍楼学生数
     * @param buildingsId
     * @return
     */
    Integer getStudentCountByBuildingsId(Integer buildingsId);

    /**
     * 新增宿舍楼
     * @param condition
     */
    void add(String condition);

    /**
     * 删除宿舍楼
     * @param id
     */
    void delete(Integer id);
}
