package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Canteen;
import com.zstu.edu.entity.Repair;
import com.zstu.edu.entity.Stall;
import com.zstu.edu.entity.StallVO;
import com.zstu.edu.mapper.StallMapper;
import com.zstu.edu.service.CanteenService;
import com.zstu.edu.service.DishesService;
import com.zstu.edu.service.StallService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 档口 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-10
 */
@Service
public class StallServiceImpl extends ServiceImpl<StallMapper, Stall> implements StallService {

    @Autowired
    StallMapper stallMapper;

    @Autowired
    CanteenService canteenService;

    @Autowired
    DishesService dishesService;

    @Override
    public Integer add(Stall stall) {
        stallMapper.insert(stall);
        return stall.getId();
    }

    @Override
    public PageInfo<Stall> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Integer canteenId = jsonObject.getInteger("canteenId");
        String stallName = jsonObject.getString("stallName");
        PageHelper.startPage(current, size);
        List<Stall> stallList = stallMapper.selectByCondition(canteenId, stallName);
        for (Stall stall : stallList) {
            stall.setCanteen(canteenService.getById(stall.getCanteenId()));
        }
        PageInfo<Stall> stallListPageInfo = new PageInfo<>(stallList);
        return stallListPageInfo;
    }

    @Override
    public void delete(Integer id) {
        stallMapper.deleteById(id);
    }

    @Override
    public List<Stall> getByCanteenId(Integer canteenId) {
        return stallMapper.selectByCanteenId(canteenId);
    }

    @Override
    public List<StallVO> getCascader() {
        ArrayList<StallVO> stallVOS = new ArrayList<>();
        List<Canteen> canteenList = canteenService.getAll();
        for (Canteen canteen : canteenList) {
            StallVO stallVO = new StallVO();
            stallVO.setValue(canteen.getId());
            stallVO.setLabel(canteen.getName());
            stallVOS.add(stallVO);
        }
        for (StallVO stallVO : stallVOS) {
            ArrayList<StallVO> stallVOS1 = new ArrayList<>();
            List<Stall> stallList = getByCanteenId(stallVO.getValue());
            for (Stall stall : stallList) {
                StallVO stallVO1 = new StallVO();
                stallVO1.setLabel(stall.getName());
                stallVO1.setValue(stall.getId());
                stallVOS1.add(stallVO1);
            }
            stallVO.setChildren(stallVOS1);
        }
        for (StallVO stallVO : stallVOS) {
            stallVO.setValue(stallVO.getValue() * 100000);
        }
        return stallVOS;
    }

    @Override
    public Stall getById(Integer id) {
        Stall stall = stallMapper.selectById(id);
        stall.setDishesList(dishesService.getByStallId(id));
        return stall;
    }

    @Override
    public void updateHealth(String condition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(condition);
        Integer id = jsonObject.getInteger("id");
        String healthPhoto = jsonObject.getString("healthPhoto");
        Double healthScore = jsonObject.getDouble("healthScore");
        Date collectionTime = jsonObject.getDate("collectionTime");
        System.out.println("11111111");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm");
        String dateString = sdf.format(collectionTime);
        System.out.println(dateString);
        stallMapper.updateHealth(id, healthPhoto, healthScore, collectionTime);
    }
}
