package com.lea.kumiko.midware.bean;

import lombok.Data;

@Data
public class MsgDetectBean {

    private Long talker;

    private Long qwxid;

    private Long fromUser;

    private Long msgTime;

    private Integer ruleType;

    private String detectContent;

    private Integer chatMode;

    private Integer msgType;

    private String ruleGroupKey;



}
