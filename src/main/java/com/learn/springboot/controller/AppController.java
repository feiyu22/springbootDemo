package com.learn.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ThinkPad on 2017/10/11.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @RequestMapping("/checkVersion")
    public String checkVersion(){
        String version = "{\"versionName\":\"1.0.1\",\"versionCode\":2,\"description\":\"版本检测测试\",\"downloadUrl\":\"http://fun.dafeiyu.cn/apk/ddsf-xx.apk\"}";
        return version;
    }

}
