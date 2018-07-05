package com.xuan.test;

import com.xuan.beanconfig.IOCConfig;
import com.xuan.beanconfig.MyConfig02;
import com.xuan.model.Fruit;
import com.xuan.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:25  七月
 * @Description:
 * @ModifyBy:
 */
public class IOCTest {

    @Test
    public void testImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig02.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String string: beanDefinitionNames) {
            System.out.println(string);
        }

        System.out.println("==================testImport 分割线=======================");
//        System.out.println(applicationContext.getBean("fruit"));
        System.out.println(applicationContext.getBean(Fruit.class));

        /**
         * Used to dereference a {@link FactoryBean} instance and distinguish it from
         * beans <i>created</i> by the FactoryBean. For example, if the bean named
         * {@code myJndiObject} is a FactoryBean, getting {@code &myJndiObject}
         * will return the factory, not the instance returned by the factory.
         *  在BeanFactory 接口中的定义   String FACTORY_BEAN_PREFIX = "&";
         *
         */
        System.out.println("----------------分割线--------------");
        System.out.println(applicationContext.getBean("&fruit").getClass());
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig02.class);
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment);
        System.out.println("-----------分割线--------------");
        System.out.println(environment.getProperty("os.name"));
        System.out.println("-----------分割线--------------");
        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        personMap.forEach((k,v)->System.out.println("key: " + k + ",-->value : " + v));
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig02.class);
        System.out.println("ioc启动完成");
        Object person1 = applicationContext.getBean("person");
//        Object person2 = applicationContext.getBean("person");
//        System.out.println(person1 == person2);
    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IOCConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String string: beanDefinitionNames) {
            System.out.println(string);
        }
    }
}
