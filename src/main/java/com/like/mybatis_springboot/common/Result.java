package com.like.mybatis_springboot.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;
    private Map map=new HashMap();

    //成功
    public static <T> Result<T> success(T obj){
        Result<T> res=new Result<T>();
        res.data=obj;
        res.code=1;
        return  res;
    }
    public static <T> Result<T> error(String msg) {
        Result res = new Result();
        res.msg = msg;
        res.code = 0;
        return res;
    }

    public Result<T> add(String key,Object value){
        this.map.put(key,value);
        return  this;
    }
}
