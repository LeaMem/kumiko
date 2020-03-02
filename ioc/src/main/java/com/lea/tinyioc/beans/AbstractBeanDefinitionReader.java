package com.lea.tinyioc.beans;

import com.lea.tinyioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry(){
        return registry;
    }

    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
}
