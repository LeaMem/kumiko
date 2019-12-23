package com.lea.kumiko.winter.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "current")
    public String current(){
        return Thread.currentThread().getName();
    }

}
