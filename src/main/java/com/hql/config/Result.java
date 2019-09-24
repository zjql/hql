package com.hql.config;

import lombok.Data;

/**
 * @author 开发者中文姓名
 * @date 2019/9/24 16:18
 */
@Data
public class Result {
    //响应码
    private int code;

    public Result(int code){
        this.code = code;
    }
}
