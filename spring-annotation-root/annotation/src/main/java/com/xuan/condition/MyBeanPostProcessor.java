package com.xuan.condition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:51  七月
 * @Description: 自定义后置处理器实现,bean初始化前后工作
 * @ModifyBy:
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization，bean==>"+bean + ",beanName==>" + beanName);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        System.out.println("postProcessAfterInitialization，bean==>"+bean + ",beanName==>" + beanName);

        return bean;
    }
}
