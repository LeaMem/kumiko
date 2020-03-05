package com.lea.tinyioc.beans.factory;

import com.lea.tinyioc.beans.BeanDefinition;
import com.lea.tinyioc.beans.BeanPostProcessor;
import com.lea.tinyioc.test.HelloWorldService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        Object bean = beanDefinition.getBean();

        if (bean == null) {

            bean = doCreateBean(beanDefinition);

            if(bean instanceof HelloWorldService){
                ((HelloWorldService) bean).helloWorld();
            }

            bean = initializeBean(bean, name);

            if(bean instanceof HelloWorldService){
                ((HelloWorldService) bean).helloWorld();
            }

            beanDefinition.setBean(bean);


        }

        return bean;
    }

    protected Object initializeBean(Object bean, String name) throws Exception {


        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        //todo: initialize method
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);

            //这里好像出现了问题，我不知道怎么解决
//            System.out.println(bean.getClass());
//            if (bean instanceof HelloWorldService) {
//                ((HelloWorldService) bean).helloWorld();
//                System.out.println("------------ " + bean.getClass() + " ----------");
//            }

        }

        return bean;
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);

//        if(bean instanceof HelloWorldService){
//            ((HelloWorldService) bean).helloWorld();
//        }

        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext(); ) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

}
