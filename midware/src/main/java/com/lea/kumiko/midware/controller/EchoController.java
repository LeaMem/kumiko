package com.lea.kumiko.midware.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class EchoController {

    @RequestMapping(value = "/{pt:h5pt|pt}/echo")
    public String echo(String str){
        return "echo: " + str;
    }

    public static void main(String[] args) {

        String str = "pt";
        Pattern pattern = Pattern.compile("(h5)?pt");

        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.find());
    }

}
