package com.lea.tinyioc;

import com.lea.tinyioc.context.ApplicationContext;
import com.lea.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void test() throws Exception{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }

}
