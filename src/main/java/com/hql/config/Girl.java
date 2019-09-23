package com.hql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 开发者中文姓名
 * @date 2019/9/23 11:07
 */
@Data
@Component
@ConfigurationProperties(prefix = "girl")
public class Girl {

    private String name;
    private String age;
    private String sex;
}
