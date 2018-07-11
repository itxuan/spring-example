package com.xuan.beanconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/11 15:29  七月
 * @Description:
 * @ModifyBy:
 */
// 如果写在类上,对应的环境才能被加载
//@Profile("test")
@PropertySource("classpath:/db.properties")
@Configuration
public class IocConfigOfProfile implements EmbeddedValueResolverAware {

    //@Profile 默认用default
    //1、运行方式： -Dspring.profiles.active= 环境标识
    //2、 代码方式  --> @see com.xuan.test.IOC_ProfileTest

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClassName;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String password){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUsername(user);
        ((DruidDataSource) dataSource).setPassword(password);
        ((DruidDataSource) dataSource).setUrl(resolver.resolveStringValue("${db.testUrl}"));
        ((DruidDataSource) dataSource).setDriverClassName(resolver.resolveStringValue("${db.driverClassName}"));
        return dataSource;
    }
    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String password){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUsername(user);
        ((DruidDataSource) dataSource).setPassword(password);
        ((DruidDataSource) dataSource).setUrl(resolver.resolveStringValue("${db.Url}"));
        ((DruidDataSource) dataSource).setDriverClassName(resolver.resolveStringValue("${db.driverClassName}"));
        return dataSource;
    }
    @Profile("pro")
    @Bean("proDataSource")
    public DataSource dataSourcePro(@Value("${db.password}")String password){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUsername(user);
        ((DruidDataSource) dataSource).setPassword(password);
        ((DruidDataSource) dataSource).setUrl(resolver.resolveStringValue("${db.proUrl}"));

        ((DruidDataSource) dataSource).setDriverClassName(resolver.resolveStringValue(driverClassName));
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        this.resolver = resolver;
        driverClassName = resolver.resolveStringValue("${db.driverClassName}");
    }
}
