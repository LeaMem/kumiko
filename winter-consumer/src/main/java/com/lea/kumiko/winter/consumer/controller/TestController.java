package com.lea.kumiko.winter.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "current")
    public LocalDateTime current(LocalDateTime localDateTime){
        return localDateTime;
    }

}
