package com.learn.springboot.service;

import com.learn.springboot.model.Cat;

/**
 * Created by ThinkPad on 2018/3/24.
 */
public interface CatService {

    Cat getById(int id) throws Exception;

    void addCat(Cat cat)throws Exception;
}
