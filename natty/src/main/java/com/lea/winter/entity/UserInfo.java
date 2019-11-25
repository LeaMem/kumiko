package com.lea.winter.entity;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class UserInfo {

    private static AtomicInteger uidGener = new AtomicInteger(1000);

    //是否认证
    private boolean isAuth = false;

    //登录时间
    private long time = 0;

    //UID
    private int userId;

    //昵称
    private String nick;

    //地址
    private String addr;


    //通道
    private Channel channel;





}
