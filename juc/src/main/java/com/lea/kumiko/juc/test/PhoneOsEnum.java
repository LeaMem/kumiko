package com.lea.kumiko.juc.test;

public enum PhoneOsEnum {

    /**
     * 安卓
     */
    ANDROID(1, "android"),

    /**
     * ios
     */
    IOS(2, "ios");


    private final Integer type;
    private final String typeName;

    PhoneOsEnum(Integer type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public static void main(String[] args) {
        Class<PhoneOsEnum> phoneOsEnumClass = PhoneOsEnum.class;
        PhoneOsEnum[] enumConstants = phoneOsEnumClass.getEnumConstants();
        for (PhoneOsEnum enumConstant : enumConstants) {
            System.out.println(enumConstant);
        }
    }
}