package com.xuan.extend;

import com.xuan.model.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/19 10:07  七月
 * @Description:  扩展原理相关
 *              BeanPostProcessor: bean 后置处理器---- bean 创建对象初始化前后进行拦截操作
 *              1、BeanFactoryPostProcessor :beanFactory 后置处理器
 *                  Modify the application context's internal bean factory after its standard
 * 	            initialization. All bean definitions will have been loaded, but no beans
 * 	            will have been instantiated yet
 *              BeanFactoryPostProcessor原理：
 *              1）、 ioc容器创建对象
 *              2)、调用 AbstractApplicationContext.invokeBeanFactoryPostProcessors(beanFactory)
 *                      按照PriorityOrdered、 Ordered、the rest(也就是普通的)
 *                      invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);
 *                      在初始化其他的组件前执行
 *
 *        2、  BeanDefinitionRegistryPostProcessor  （子接口）
 *        interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *          原理参考上面的BeanFactoryPostProcessor
 *
 *        3、 ApplicationListener
 *          interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *          监听ApplicationEvent及子类的事件
 *
 *          1）、创建监听器监听某一个事件(ApplicationEvent 及子类的事件,可以继承ApplicationEvent 自定义事件)
 *          2）、将监听器加入Spring 容器
 *          3）、容器如果发布该事件，就会被监听到
 *                  Spring容器启动和关闭发布的事件：ContextRefreshedEvent、ContextClosedEvent
 *          4）、自己发布一个事件
 *
 *
 * @ModifyBy:
 */
@ComponentScan(value = "com.xuan.extend")
@Configuration
public class ExtendConfiguration {


    @Bean
    public Red red(){
        return new Red();
    }
}
