package com.xuan.beanconfig;

import com.xuan.dao.BookDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:23  七月
 * @Description:  useDefaultFilters属性参考网址 :
 *                      https://blog.csdn.net/afterlife_qiye/article/details/71091940
 * @ModifyBy:
 */
@Configuration
@ComponentScan(value = "com.xuan",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
//                Controller.class,Service.class
//        }),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {
//                BookDao.class
//        })
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
},useDefaultFilters =false)
/**
 * @ComponentScan value 指定要扫面的包，
 *  excludeFilters = Filter[] 排除指定规则下的组件
 *  includeFilters = Filter[]  与useDefaultFilters 一起使用
 *  useDefaultFilters 表示：
 *      对于context标签，都是交由ContextNamespaceHandler处理
 *      ContextNamespaceHandler类中init()  ComponentScanBeanDefinitionParser
 *      protected ClassPathBeanDefinitionScanner
 *          configureScanner(ParserContext parserContext, Element element) {}调用这个方法,注册组件
 *
 *  FilterType 过滤策略：
 *      FilterType.ANNOTATION 表示注解方式来过滤
 *      FilterType.ASSIGNABLE_TYPE 按照指定的Class 类来过滤
 *      FilterType.ASPECTJ 使用ASPECTJ 表达式
 *      FilterType.REGEX 使用正则表达式
 *      FilterType.CUSTOM 自定义规则
 *          {
 *              方式
 *          }
 */
public class IOCConfig {

}
