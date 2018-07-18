package com.xuan.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 10:28  七月
 * @Description:  spring 声明式事务
 *                  1、导入数据源 数据库驱动  spring-jdbc  依赖
 *                  2、 配置
 *                  3、 方法上加入@Transactional  配置类上加 @EnableTransactionManagement 开启事务管理
 *                  4、 配置事务管理器
 *                      @Bean
 *                      public PlatformTransactionManager transactionManager(){
 *                              DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
 *                              return dataSourceTransactionManager;
 *                          }
 * @ModifyBy:
 */
@Configuration
@PropertySource(value = "classpath:/db.properties")
@ComponentScan(value = {"com.xuan.service","com.xuan.dao"})
// 开启事务管理
@EnableTransactionManagement
public class TxConfig {

    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Value("${db.driverClassName}")
    private String driveClassName;
    @Value("${db.testUrl}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DruidDataSource();

        ((DruidDataSource) dataSource).setUsername(user);
        ((DruidDataSource) dataSource).setPassword(password);
        ((DruidDataSource) dataSource).setUrl(jdbcUrl);
        ((DruidDataSource) dataSource).setDriverClassName(driveClassName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    // 配置事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(){

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
        return dataSourceTransactionManager;
    }
}
