package com.hql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJms
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class HqlApplication {

    private static Logger logger = LogManager.getLogger(HqlApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HqlApplication.class, args);
        logger.info("hql启动成功");
    }

}
