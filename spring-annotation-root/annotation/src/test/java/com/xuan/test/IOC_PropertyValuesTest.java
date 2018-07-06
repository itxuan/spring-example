package com.xuan.test;

import com.xuan.beanconfig.IocConfigOfLifeCycle;
import com.xuan.beanconfig.IocConfigOfPropertyValues;
import com.xuan.model.Person;
import com.xuan.model.lifecycle.Train;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 14:04  七月
 * @Description:
 * @ModifyBy:
 */
public class IOC_PropertyValuesTest {


    @Test
    public void propertyValueOfPerson(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfPropertyValues.class);
        System.out.println("ioc 容器创建");
        System.out.println(applicationContext.getBean("person"));
    }
}
