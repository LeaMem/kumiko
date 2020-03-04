package com.lea.tinyioc.beans.factory;

import com.lea.tinyioc.aop.BeanFactoryAware;
import com.lea.tinyioc.beans.BeanDefinition;
import com.lea.tinyioc.BeanReference;
import com.lea.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {

        /**
         *      这里有什么用
         */
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (bean instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {

                System.out.println("set" + propertyValue.getName().substring(0, 1).toUpperCase()
                        + propertyValue.getName().substring(1));
                Method declaredMethod = bean.getClass()
                        .getDeclaredMethod("set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());

                //看懂了，这里起始就是调用 set 方法
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }

    }


}
