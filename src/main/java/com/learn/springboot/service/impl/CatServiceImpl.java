package com.learn.springboot.service.impl;

import com.learn.springboot.dao.CatMapper;
import com.learn.springboot.model.Cat;
import com.learn.springboot.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2018/3/24.
 */
@Service
public class CatServiceImpl implements CatService {

    @Autowired
    CatMapper catMapper;

    @Override
    public Cat getById(int id) throws Exception{
        return catMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void addCat(Cat cat) throws Exception {
        catMapper.insert(cat);
    }


}
