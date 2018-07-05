package com.xuan.condition;

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
public class WindowCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");

        /**
         * context  metadata
         */
        ClassLoader classLoader = context.getClassLoader();
        System.out.println("classLoader---->"+classLoader);
        System.out.println("BeanFactory----> "+context.getBeanFactory());
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
