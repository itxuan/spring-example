package com.xuan.beanconfig;

import com.xuan.bean.FruitFactoryBean;
import com.xuan.condition.LinuxCondition;
import com.xuan.condition.MyImportBeanDefinitionRegistrar;
import com.xuan.condition.MyImportSelector;
import com.xuan.condition.WindowCondition;
import com.xuan.model.Green;
import com.xuan.model.Person;
import com.xuan.model.Red;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 10:12  七月
 * @Description:
 * @ModifyBy:
 */
@Configuration
@Import({Red.class,Green.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
/**
 *  @Import 导入容器组件  id 默认是全类名
 */
public class MyConfig02 {

    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     *
     *      prototype ： 多实例，ioc容器启动的时候,并不会把对象放到ioc容器中, 在对象获取的时候才会去创建对象，
     *      singleton：单实例，ioc 容器启动的时候就把对象放入到容器中,只创建一次
     *
     * 懒加载： @Lazy 针对单实例
     *         在容器启动之后，不创建对象，当第一次去获取的时候，才创建对象并且初始化
     */
    @Lazy
    @Scope()
    //默认是单实例
    @Bean(name = "person")
    public Person person() {
        System.out.println("MyConfig02 person方法");
        return new Person("张三",15);
    }

    /**
     * @
     *
     * @return
     */
    @Conditional(value = {WindowCondition.class})
    @Bean(name = "bill")
    public Person person01() {
        return new Person("bill Gates",15);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean(name = "linus")
    public Person person02() {
        return new Person("linus",15);
    }

    /**
     *  给容器中注册组件方式
     *  1、 包扫描+ 组件注解 （@Controller @Service @Repository @Component） 一般都是自己写的
     *  2、 @Bean注解直接返回一个对象(可以导入第三方组件)
     *  3、 @Import [给容器导入组件]
     *      1） @Import 注解 容器会自动倒入这个组件、id默认是类的全限定名
     *      2)  @ImportSelector： 返回导入的组件的类的全限定名数组
     *      3） @ImportBeanDefinitionRegistrar  手动注册bean 自定义bean
     *  4、 使用Spring 提供的FactoryBean
     */
    @Bean
    public FruitFactoryBean fruit(){
        return new FruitFactoryBean();
    }
}
