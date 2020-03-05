package com.lea.tinyioc.aop;

import com.lea.tinyioc.beans.BeanPostProcessor;
import com.lea.tinyioc.beans.factory.AbstractBeanFactory;
import com.lea.tinyioc.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {

        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }

        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        List<AspectJExpressionPointcutAdvisor> advisors =
                beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {

            if (advisor.getPointCut().getClassFilter().matches(bean.getClass())) {

                ProxyFactory advisedSupport = new ProxyFactory();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointCut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean.getClass().getInterfaces(), bean);
                advisedSupport.setTargetSource(targetSource);

                return advisedSupport.getProxy();
            }
        }

        return bean;

    }
}
