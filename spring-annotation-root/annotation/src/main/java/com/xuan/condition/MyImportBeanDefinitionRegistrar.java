package com.xuan.condition;

import com.xuan.model.Time;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 11:44  七月
 * @Description:
 * @ModifyBy:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *  AnnotationMetadata ： 当前类的注解信息
     *  BeanDefinitionRegistry  BeanDefinition注册类
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //指定bean 定义信息,scope
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Time.class);
        rootBeanDefinition.setScope("singleton");
        //自定义bean 的值
        registry.registerBeanDefinition("time",rootBeanDefinition);
        System.out.println(registry.containsBeanDefinition("time"));
    }
}
