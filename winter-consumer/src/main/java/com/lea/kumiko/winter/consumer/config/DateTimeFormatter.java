package com.lea.kumiko.winter.consumer.config;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

public class DateTimeFormatter implements Formatter<LocalDateTime> {

    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return object.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
