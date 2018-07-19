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
 *          （重要注解  @EventListener）EventListenerMethodProcessor 解析这个注解(@see SmartInitializingSingleton 原理)
 *                  原理：
 *          interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *          监听ApplicationEvent及子类的事件
 *          1）、创建监听器监听某一个事件(ApplicationEvent 及子类的事件,可以继承ApplicationEvent 自定义事件)
 *          2）、将监听器加入Spring 容器
 *          3）、容器如果发布该事件，就会被监听到
 *                  Spring容器启动和关闭发布的事件：ContextRefreshedEvent、ContextClosedEvent
 *          4）、自己发布一个事件
 *      原理:
            ContextRefreshedEvent
            自己发布的事件
            ContextClosedEvent
 *
 *          1、创建容器、 refresh
 *          2、finishRefresh();容器刷新完成会发布  publishEvent(new ContextRefreshedEvent(this));
 *          3、ContextClosedEvent
 *              容器关闭--> doClose()--> publishEvent(new ContextClosedEvent(this));
 *
 *         【事件发布的流程 】
 *                      1)、获取事件的派发器  getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType)
 *                      2)、multicastEvent 派发事件
 *                      3)、for (final ApplicationListener<?> listener : getApplicationListeners(event, type)){
 *                              Executor executor = getTaskExecutor();
 *                              3-1)、 如果 executor 不是null  异步线程派发
 *                              3-2)、 如果null  同步发布事件  doInvokeListener(listener, event);
 *                      }
 *      【事件派发器的创建】
 *          1、 容器启动  initApplicationEventMulticaster()
 *          2、如果容器中存在 applicationEventMulticaster 就直接使用
 *              如果不存在就new SimpleApplicationEventMulticaster(beanFactory);并且放入容器中
 *      【事件监听器注册】
 *          1、容器启动  refresh()
 *          2、registerListeners();
 *              根据类型获取所有的监听器，并且注册到ApplicationEventMulticaster 中
 *              String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 * 		        for (String listenerBeanName : listenerBeanNames) {
 * 			        getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 * 		        }
 *
 *       SmartInitializingSingleton 原理
 *          1、创建容器 ，refresh();
 *          2、finishBeanFactoryInitialization(beanFactory); 完成所有的单实例bean初始化
 *              1) 、通过getBean(beanName) 创建所有的单实例bean
 *              2）、判断是否是SmartInitializingSingleton 类型 如果是调用afterSingletonsInstantiated();
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
