package com.xuan.beanconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/17 09:39  七月
 * @Description:   Spring  AOP编程
 * @ModifyBy:
 *          业务逻辑类  在类运行的时候将日志进行打印 （方法之前{入参}  方法运行结束{出参}  方法异常{异常信息}）
 *          LogAspects 日志切面类
 *
 *          1、切面类和业务逻辑的类都需要交给Spring管理（切面类上需要加@Aspect）
 *          2、在切面类上的每一个通知方法 通知注解，告诉Spring何时运行（切面表达式----规则）
 * *        3、@EnableAspectJAutoProxy 开启基于注解的AOP模式   【Spring 中@EnableXXX 表示开启XX配置】
 *
 *      AOP原理
 *          org.springframework.aop.config.internalAutoProxyCreator
 */
@Configuration
@ComponentScan(value = "com.xuan.aop")
@EnableAspectJAutoProxy
public class IocConfigOfAOP {


}
