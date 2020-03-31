package com.hql.config.annotation;

import java.lang.annotation.*;

/**
 * @author zhangzhijie
 * @date 2020/3/25
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Hql {
//        String[] hql() default{};

        String hql() default "";
}
