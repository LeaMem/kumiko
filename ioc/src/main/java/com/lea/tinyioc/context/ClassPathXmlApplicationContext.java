package com.lea.tinyioc.context;

import com.lea.tinyioc.beans.factory.AbstractBeanFactory;
import com.lea.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.lea.tinyioc.beans.io.ResourceLoader;
import com.lea.tinyioc.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for(String name : xmlBeanDefinitionReader.getRegistry().keySet()){
            beanFactory.registerBeanDefinition(name, xmlBeanDefinitionReader.getRegistry().get(name));
        }
    }
}
