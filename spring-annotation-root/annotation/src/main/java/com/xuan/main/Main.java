package com.xuan.main;

import com.xuan.beanconfig.PersonConfig;
import com.xuan.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:06  七月
 * @Description:
 * @ModifyBy:
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);

        System.out.println(context.getBean(Person.class));
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String str:beanNamesForType) {
            System.out.println(str);
        }
    }
}
