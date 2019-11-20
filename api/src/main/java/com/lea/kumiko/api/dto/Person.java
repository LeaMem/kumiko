package com.lea.kumiko.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;

    private Integer age;


}
