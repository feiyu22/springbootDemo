package com.learn.springboot;

import com.learn.springboot.dao.CatMapper;
import com.learn.springboot.model.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ThinkPad on 2018/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ServiceTest {

    @Autowired
    CatMapper catMapper;

    @Transactional
    @Test
    public void transactionTest() throws Exception{
        Cat cat1 = new Cat(1,"cat1");
        Cat cat2 = new Cat(1,"cat2");
        Cat cat3 = new Cat(1,"cat3");
        Cat cat4 = new Cat(1,"cat12345678");
        Cat cat5 = new Cat(1,"cat5");
        catMapper.insert(cat1);
        catMapper.insert(cat2);
        catMapper.insert(cat3);
        catMapper.insert(cat4);
        catMapper.insert(cat5);
    }



}
