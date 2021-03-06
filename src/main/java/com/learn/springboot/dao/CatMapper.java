package com.learn.springboot.dao;

import com.learn.springboot.model.Cat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id) throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated
     */
    int insert(Cat record) throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated
     */
    Cat selectByPrimaryKey(Integer id) throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated
     */
    List<Cat> selectAll() throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cat record) throws Exception;
}