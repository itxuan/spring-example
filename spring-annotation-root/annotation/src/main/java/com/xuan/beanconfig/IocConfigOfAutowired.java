package com.xuan.beanconfig;

import com.xuan.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/6 09:26  七月
 * @Description: 自动装配配置类
 * @ModifyBy:
 */

/**
 *  自动装配:
 *      Spring 利用 DI ,完成各个组件之间的关系依赖
 *      1、 @Autowired 自动注入
 *          1)、默认优先按照类型去找容器中的组件,applicationContext.getBean(BookDao.class)
 *          2)、如果找到多个相同类型的组件,再将属性名称作为组件的id 去容器中找(按 id)
 *              @Qualifier("bookDao") 可以直接指定需要装配的组件的Id去容器中查找,不用属性名
 *          3)、 自动装配默认一定要将属性赋值好，没有就会抛出 org.springframework.beans.factory.NoSuchBeanDefinitionException
 *                  @Autowired(required = false) 可以设置成false,当bookDao 组件不存在的时候，就不注入。
 *          4）、 @Primary  让Spring在装配的时候,在未指定需要装配的组件的时候，首选被 @Primary 注解的组件
 *
 *
 *      2、 Spring 支持 @Resource (JSR250) 和@Inject(JSR330)  这两个注解是java规范
 *          @Resource 默认按照组件名称装配、单独使用，不支持@Primary
 *          @Inject (需要导入依赖 https://mvnrepository.com/artifact/javax.inject/javax.inject  )
 *
 *      3、@Autowired :可以写在构造器、参数、方法、属性上；都是从容器中获取组件的值
 *             1) 、 [在方法上] @Bean + 方法参数  参数的值从容器获取,@Autowired 可以省略
 *             2) 、 [在构造器上]  如果类中只有一个构造器，@Autowired 可以省略
 *             3) 、 [在参数的位置]
 *      4、 自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,xxx）;
 *              自定义组件需要去实现xxxAware接口,在对象创建的时候,会调用接口规定的方法注入相关的组件；
 *              ConfigurationClassPostProcessor、xxxProcessor  完成相应的功能
 */
@Configuration
@ComponentScan(value = {"com.xuan.controller","com.xuan.service","com.xuan.dao","com.xuan.model"})
public class IocConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setFlag("spring bean");
        return bookDao;
    }
}
