package com.hql.controller;

import com.hql.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 开发者中文姓名
 * @date 2019/10/22 13:37
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/set")
    public void redisSet(String key,String value){
         redisUtils.set(key,value);
    }

    @RequestMapping("/get")
    public String redisGet(String key){
        return redisUtils.get(key);
    }
    @RequestMapping("/expire")
    public void redisExpire(String key,String value,long expire){
        redisUtils.set(key,value,expire);
    }
}
