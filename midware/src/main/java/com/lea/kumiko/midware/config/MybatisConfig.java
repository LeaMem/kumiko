package com.lea.kumiko.midware.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.lea.kumiko.midware.mapper")
public class MybatisConfig {
}
