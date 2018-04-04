package com.learn.springboot.service;

import com.learn.springboot.model.PayUser;

/**
 * Created by ThinkPad on 2018/3/26.
 */
public interface PayService {

    boolean addPayUser(PayUser user) throws Exception;

    PayUser getByOrderId(String orderId) throws Exception;

    boolean changePayOrder(PayUser user) throws Exception;
}
