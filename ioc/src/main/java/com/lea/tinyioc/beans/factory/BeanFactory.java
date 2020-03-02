package com.lea.tinyioc.beans.factory;

import com.lea.tinyioc.beans.BeanDefinition;


public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
