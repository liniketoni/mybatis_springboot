package com.like.mybatis_springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class fetchDate {
    public String RightNow(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
