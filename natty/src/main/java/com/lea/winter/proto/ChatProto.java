package com.lea.winter.proto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ChatProto {

    public static final int PING_PROTO = 1 << 8 | 220; //ping消息

    public static final int PONG_PROTO = 2 << 8 | 220; //pong消息

    public static final int SYST_PROTO = 3 << 8 | 220; //系统错误

    public static final int EROR_PROTO = 4 << 8 | 220; //错误消息

    public static final int AUTH_PROTO = 5 << 8 | 220; //认证错误

    public static final int MESS_PROTO = 6 << 8 | 220; //普通消息


    private int version = 1;

    private int uri;

    private String body;

    private Map<String, Object> extend = new HashMap<>();

    public ChatProto(int head, String body) {
        this.uri = head;
        this.body = body;
    }


    public static void main(String[] args) {
        System.out.println(3 << 8);
        System.out.println(PONG_PROTO);
    }

}
