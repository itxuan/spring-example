package com.xuan.model;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/11 14:38  七月
 * @Description:  实现  xxxAware接口中的方法，引入Spring 一些底层的组件
 * @ModifyBy:
 */
@Component
public class Student implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("applicationContext:"+applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("字符串解析器:" + resolver.resolveStringValue("${os.name} 10*10= #{10*10}"));
    }
}
