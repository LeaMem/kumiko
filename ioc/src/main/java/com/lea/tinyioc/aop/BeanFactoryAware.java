package com.lea.tinyioc.aop;

import com.lea.tinyioc.beans.factory.BeanFactory;

public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;

}
