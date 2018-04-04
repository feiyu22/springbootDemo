package com.learn.springboot.dao;


import com.learn.springboot.model.PayUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(PayUser record);

    PayUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayUser record);

    int updateByOrderId(PayUser record);

    PayUser selectByOrderId(String order);

}