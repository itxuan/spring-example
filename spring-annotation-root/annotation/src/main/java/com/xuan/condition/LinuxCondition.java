package com.xuan.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 10:53  七月
 * @Description:
 * @ModifyBy:
 */
public class LinuxCondition implements Condition {

    /**
     *
     * @param context ConditionContext 判断条件可以使用的上下文(环境)
     * @param metadata AnnotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1 获取 ioc 使用的 beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3 获取ioc 当前的环境
        Environment environment = context.getEnvironment();
        //4 或者bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        String property = environment.getProperty("os.name");
        if(property.contains("linux")){
            return true;
        }
        return false;
    }
}
