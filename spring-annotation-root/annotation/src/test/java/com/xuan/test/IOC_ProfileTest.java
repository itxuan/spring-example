package com.xuan.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.xuan.beanconfig.IocConfigOfAutowired;
import com.xuan.beanconfig.IocConfigOfProfile;
import com.xuan.model.Student;
import com.xuan.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/6 9:33  七月
 * @Description:
 * @ModifyBy:
 */
public class IOC_ProfileTest {

    @Test
    public void profile() throws SQLException {

        // 代码方式激活环境
        //  1、 创建applicationContext  不可以使用有参构造器
        //  public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
        //		this();
        //		register(annotatedClasses);
        //		refresh();
        //	}

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 2、 设置运行的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        // 3、注册主配置类
        applicationContext.register(IocConfigOfProfile.class);
        //4、 刷新容器
        applicationContext.refresh();

        String[] strs = applicationContext.getBeanNamesForType(DataSource.class);
        for (String str : strs){
            System.out.println(str);
        }


//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfigOfProfile.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String s :beanDefinitionNames){
//
//            System.out.println(s);
//        }
//        DataSource testDataSource = (DataSource) applicationContext.getBean("testDataSource");
//
//        Connection connection = testDataSource.getConnection();
////        PreparedStatement s = connection.prepareStatement("create table hello(id bigint(10),name varchar (20))");
//        PreparedStatement statement = connection.prepareStatement("insert into hello values (2,'xuan')");
////        System.out.println(statement.execute());
//        statement.close();
//        connection.close();
//        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

}
