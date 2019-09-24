package com.hql.controller;

import com.hql.config.Girl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 开发者中文姓名
 * @date 2019/9/23 11:12
 */
@RestController
@RequestMapping("text")
public class TextController {

    private static Logger logger = LogManager.getLogger(TextController.class);

    @Autowired
    private Girl girl;

    @Value("${spring.profiles.active}")
    private String active;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.POST)
    public String init(){
        return "strive"+girl.getName()+girl.getSex()+girl.getAge();
    }

    @RequestMapping(value = "/show/{id}",method = RequestMethod.GET)
    public String show(@PathVariable Integer id){
        return active+girl.getName()+girl.getSex()+girl.getAge()+id;
    }

    @RequestMapping(value = "/see",method = RequestMethod.GET)
    public String see(@RequestParam Integer id){
        return active+girl.getName()+girl.getSex()+girl.getAge()+id;
    }

    //@RequestMapping(value = "/seetwo",method = RequestMethod.GET)
    @GetMapping("/seetwo")
    public String see2(@RequestParam(value = "id",required = true, defaultValue = "10") Integer id){
        //required 是否必传    defaultValue 默认值
        return active+girl.getName()+girl.getSex()+girl.getAge()+id;
    }

    @Scheduled(cron = "* * * * 1 ?")
    public void show(){
        System.out.println(new Date());
        logger.info("Hello world");
    }
}
