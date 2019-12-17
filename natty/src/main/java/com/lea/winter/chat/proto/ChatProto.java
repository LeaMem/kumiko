package com.lea.winter.chat.proto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static String buildMessProto(int uid, String nick, String mess){
        ChatProto chatProto = new ChatProto(MESS_PROTO, mess);
        chatProto.extend.put("uid", uid);
        chatProto.extend.put("nick", nick);
        chatProto.extend.put("time", getTime());
        return JSONObject.toJSONString(chatProto);
    }

    public static String buildSysProto(int code, Object mess){
        ChatProto chatProto = new ChatProto(SYST_PROTO, null);
        chatProto.extend.put("code", code);
        chatProto.extend.put("mess", mess);
        return JSONObject.toJSONString(chatProto);
    }


    public static String buildPingProto(){
        return buildProto(PING_PROTO, null);
    }

    public static String buildProto(int head, String body){
        ChatProto chatProto = new ChatProto(head, body);
        return JSONObject.toJSONString(chatProto);
    }

    public static final String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) {
        System.out.println(3 << 8);
        System.out.println(PONG_PROTO);
    }

}
