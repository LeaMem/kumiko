package com.lea.tinyioc.beans;

/**
 *      从配置文件中读取BeanDefinitionReader
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
