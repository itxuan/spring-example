package com.xuan.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 10:11  七月
 * @Description:
 * @ModifyBy:
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println( "MyBeanFactoryPostProcessor  postProcessBeanFactory bean count "+ beanFactory.getBeanDefinitionCount());
        System.out.println(Arrays.asList(beanFactory.getBeanDefinitionNames()));
    }
}
