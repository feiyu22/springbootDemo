package com.learn.springboot.controller;

import com.learn.springboot.model.Cat;
import com.learn.springboot.model.User;
import com.learn.springboot.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by ThinkPad on 2017/9/29.
 */
@Controller
public class HelloController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CatService catService;

    @RequestMapping("")
    String index() {
        LOGGER.debug("debug 日志输出");
        return "index";
    }

    @RequestMapping("2")
    String index2() {
        return "index2";
    }

    @RequestMapping("/now")
    @ResponseBody
    String getNow() {
        return "现在时间：" + (new Date()).toLocaleString();
    }

    @RequestMapping("/user")
    @ResponseBody
    User getUser() {
        User user = new User();
        user.setName("dafeiyu");
        user.setStatus(1);
        user.setCreateDate(new Date());
        return user;
    }

    @RequestMapping("/getCat")
    @ResponseBody
    Cat getCat() throws Exception{
        Cat cat = catService.getById(1);
        return cat;
    }

    @RequestMapping(value = "/addCat",method= RequestMethod.POST)
    @ResponseBody
    String addCat(@Valid Cat cat,BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            List<FieldError> listError = bindingResult.getFieldErrors();
            StringBuffer bf = new StringBuffer();
            for(FieldError error:listError){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
                bf.append(error.getField()+":"+error.getDefaultMessage());
            }
            return bf.toString();
        }
        catService.addCat(cat);
        return "添加成功";
    }

}
