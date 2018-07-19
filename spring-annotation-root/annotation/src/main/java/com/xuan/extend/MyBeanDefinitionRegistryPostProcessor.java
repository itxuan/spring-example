package com.xuan.extend;

import com.xuan.model.Fruit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 10:45  七月
 * @Description:
 * @ModifyBy:
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // bean 注册中心 保存了bean 的定义信息(eg： 单例or多例  类型  id ...)
        System.out.println("postProcessBeanDefinitionRegistry..bean count" + registry.getBeanDefinitionCount());

        // 自定义注册组件
//        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Fruit.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Fruit.class).getBeanDefinition();
        registry.registerBeanDefinition("fruit",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory bean count:" + beanFactory.getBeanDefinitionCount());
    }
}
