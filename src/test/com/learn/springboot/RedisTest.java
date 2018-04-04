package com.learn.springboot;

import com.learn.springboot.model.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ThinkPad on 2018/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisConnectionFactory factory;

    @Autowired
    RedisTemplate<String, Object> template;

    @Test
    public void testRedis(){
        //得到一个连接
        RedisConnection conn = factory.getConnection();
        conn.set("hello".getBytes(), "world".getBytes());
        System.out.println(new String(conn.get("hello".getBytes())));
    }

    @Test
    public void testRedisTemplate(){
        template.opsForValue().set("key1", "value1");
        Object result = template.opsForValue().get("key1");
        LOGGER.info(result.toString());
    }

    @Test
    public void testRedisTemplateList(){
        Cat tom  = new Cat(1, 2, "tom");
//        Cat jerry  = new Cat(2, 3, "jerry");
//        //依次从尾部添加元素
//        template.opsForList().rightPush("cats", tom);
//        template.opsForList().rightPush("cats", jerry);
//        //查询索引0到商品总数-1索引（也就是查出所有的商品）
        List<Object> prodList = template.opsForList().range("cats", 0,template.opsForList().size("cats")-1);
        for(Object obj:prodList){
            Cat cat = (Cat) obj;
            LOGGER.info(cat.getCatName());
        }
        System.out.println("cat的数量:"+template.opsForList().size("cats"));

    }

}