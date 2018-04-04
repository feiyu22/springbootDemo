package com.learn.springboot.service.impl;

import com.learn.springboot.dao.PayUserMapper;
import com.learn.springboot.model.PayUser;
import com.learn.springboot.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ThinkPad on 2018/3/26.
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    PayUserMapper payUserMapper;

    @Override
    public boolean addPayUser(PayUser user) throws Exception {
        int i = payUserMapper.insertSelective(user);
        return i>0?true:false;
    }

    @Override
    public PayUser getByOrderId(String orderId) throws Exception {
        return payUserMapper.selectByOrderId(orderId);
    }

    @Override
    public boolean changePayOrder(PayUser user) throws Exception {
        if(user.getOrderId()==null){
            return false;
        }
        int i = payUserMapper.updateByOrderId(user);
        return i>0?true:false;
    }


}
