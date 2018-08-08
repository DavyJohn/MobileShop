package com.huatec.edu.mobileshop.entity;

/**
 * Created by NTVU on 2018/8/7.
 * 基础数据源
 */

public class HttpResult<T> {
    private String code;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
