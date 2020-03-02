package com.lea.tinyioc;


import com.lea.tinyioc.beans.BeanDefinition;
import com.lea.tinyioc.beans.factory.AbstractBeanFactory;
import com.lea.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.lea.tinyioc.beans.factory.BeanFactory;
import com.lea.tinyioc.beans.io.ResourceLoader;
import com.lea.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        // 1. 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2. 初始化 BeanFactory 并且注册bean
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
//            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
//        }

        // 3. 获取 bean
//        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
//        helloWorldService.helloWorld();

    }


    @Test
    public void testPreInstantiate() throws Exception {

        // 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 初始化 BeanFactory 并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (String name : xmlBeanDefinitionReader.getRegistry().keySet()) {
            beanFactory.registerBeanDefinition(name, xmlBeanDefinitionReader.getRegistry().get(name));
        }

        //初始化
        beanFactory.preInstantiateSingletons();

        //获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }


}
