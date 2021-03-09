package com.zstu.edu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zstu.edu.entity.Canteen;
import com.zstu.edu.entity.Dishes;
import com.zstu.edu.entity.Feedback;
import com.zstu.edu.entity.Stall;
import com.zstu.edu.mapper.FeedbackMapper;
import com.zstu.edu.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 反馈 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2021-02-24
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    DishesService dishesService;

    @Autowired
    StallService stallService;

    @Autowired
    UserService userService;

    @Override
    public void add(Feedback feedback) {
        feedbackMapper.insert(feedback);

        Double scoreAvg = feedbackMapper.selectScoreAvgByDishesId(feedback.getDishesId());
        Dishes dishes = dishesService.getById(feedback.getDishesId());
        dishes.setScore(scoreAvg);
        dishesService.updateById(dishes);

        Double scoreAvg2 = feedbackMapper.selectScoreAvgByStallId(feedback.getStallId());
        Stall stall = stallService.getById(feedback.getStallId());
        stall.setFeedbackScore(scoreAvg2);
        stallService.updateById(stall);
    }

    @Override
    public PageInfo<Feedback> getByCondition(String queryCondition) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(queryCondition);
        Integer current = jsonObject.getInteger("current");
        Integer size = jsonObject.getInteger("size");
        Integer userId = jsonObject.getInteger("userId");
        Integer dishesId = jsonObject.getInteger("dishesId");
        PageHelper.startPage(current, size);
        List<Feedback> feedbackList = feedbackMapper.selectByCondition(userId,dishesId);
        for (Feedback feedback : feedbackList) {
            feedback.setStall(stallService.getById(feedback.getStallId()));
            feedback.setDishes(dishesService.getById(feedback.getDishesId()));
            feedback.setUser(userService.getById(feedback.getStudentId()));
        }
        PageInfo<Feedback> feedbackPageInfo = new PageInfo<>(feedbackList);
        return feedbackPageInfo;
    }

    @Override
    public void deleteById(Integer id) {
        Feedback feedback = feedbackMapper.selectById(id);
        feedbackMapper.deleteById(id);

        Double scoreAvg = feedbackMapper.selectScoreAvgByDishesId(feedback.getDishesId());
        Dishes dishes = dishesService.getById(feedback.getDishesId());
        dishes.setScore(scoreAvg);
        dishesService.updateById(dishes);

        Double scoreAvg2 = feedbackMapper.selectScoreAvgByStallId(feedback.getStallId());
        Stall stall = stallService.getById(feedback.getStallId());
        stall.setFeedbackScore(scoreAvg2);
        stallService.updateById(stall);
    }

    @Override
    public boolean updateById(Feedback feedback) {
        feedbackMapper.updateById(feedback);

        Double scoreAvg = feedbackMapper.selectScoreAvgByDishesId(feedback.getDishesId());
        Dishes dishes = dishesService.getById(feedback.getDishesId());
        dishes.setScore(scoreAvg);
        dishesService.updateById(dishes);

        Double scoreAvg2 = feedbackMapper.selectScoreAvgByStallId(feedback.getStallId());
        Stall stall = stallService.getById(feedback.getStallId());
        stall.setFeedbackScore(scoreAvg2);
        stallService.updateById(stall);
        return true;
    }
}
