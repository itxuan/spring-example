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
 *          原理分析:
 *              1、@EnableTransactionManagement
 *                  利用TransactionManagementConfigurationSelector给容器添加组件
 *                  导入两个组件
 *                  （1） AutoProxyRegistrar
 *                          1)、 给容器注册 InfrastructureAdvisorAutoProxyCreator 组件
 *                          2）、InfrastructureAdvisorAutoProxyCreator 利用后置处理器在创建对象之后，返回一个代理对象（增强），代理对象执行方法利用拦截器链进行调用。
 *                  （2） ProxyTransactionManagementConfiguration
 *                          1、这是个配置类，给容器注册事务增强器  transactionAdvisor()
 *                                  AnnotationTransactionAttributeSource
 *                                  使用 SpringTransactionAnnotationParser、JtaTransactionAnnotationParser(或者Ejb3TransactionAnnotationParser)
 *                                  事务拦截器：
 *                                      TransactionInterceptor :保存了事务属性  SpringTransactionAnnotationParser
 *                                      这是一个MethodInterceptor
 *                                      在目标方法执行的时候
 *                                          执行拦截器链 事务拦截器
 *                                              1）获取事务的属性
 *                                              2）  获取PlatformTransactionManager
 *                                              3） 执行事务反射方法 出现异常进行回滚操作
 *
 *
 *
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
