package com.lea.winter.proto;

public class ChatProto {

    public static final int PING_PROTO = 1 << 8 | 220; //ping消息


    public static void main(String[] args) {
        System.out.println(1 << 8);
        System.out.println(PING_PROTO);
    }

}
