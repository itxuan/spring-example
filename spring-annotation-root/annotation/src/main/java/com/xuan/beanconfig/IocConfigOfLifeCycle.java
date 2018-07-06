package com.xuan.beanconfig;

import com.xuan.model.lifecycle.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 13:58  七月
 * @Description: bean 的生命周期
 *                  bean 创建--> 初始化-->销毁
 * @ModifyBy:
 */
@ComponentScan(value = {"com.xuan.model.lifecycle","com.xuan.condition"})
@Configuration
public class IocConfigOfLifeCycle {

    //1、指定对象的初始化和销毁方法 init-method ,destroy-method
    /**
     *  初始化：
     *     单实例：容器启动创建实例
     *     多实例：不初始化实例对象,获取时候才创建
     *  销毁：
     *      单实例：容器关闭
     *      多实例： 容器不管理
     *      eg:Car
     *
     * 2、 Spring 提供创建接口 InitializingBean
     *              销毁接口：DisposableBean
     *      eg:Train
     *
     * 3、 Spring 提供的注解：
     *         @PostConstruct 在对象创建并且赋值完成之后被调用
     *         @PreDestroy   在容器移除对象之前
     *         eg :Sheep
     *
     *  4、 Spring提供  、BeanPostProcessor 接口
     *              postProcessBeforeInitialization：before InitializingBean's {@code afterPropertiesSet} or a custom init-method
     *              postProcessAfterInitialization：given new bean instance <i>after</i> any bean initialization callbacks
     *              (like InitializingBean's {@code afterPropertiesSet} or a custom init-method)
     *
     *
     *              wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     *              invokeInitMethods(beanName, wrappedBean, mbd);
     *              wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     */

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
