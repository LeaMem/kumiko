package com.lea.kumiko.winter.consumer.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "current")
    public String current(@DateTimeFormat(pattern = "yyyy-MM")LocalDate localDate){
        return localDate.toString();
    }

}
