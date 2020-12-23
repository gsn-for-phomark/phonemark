package com.gsn.pm;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.gsn")
@EnableTransactionManagement  //开启事务管理
public class DaoConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://101.200.216.156:3306/PhoneMark?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong\n");
        dataSource.setUsername("root");
        dataSource.setPassword("Asd8711341");
        return dataSource;
    }

    @Bean   //联接工厂
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PageInterceptor pi =new PageInterceptor();
        bean.setPlugins(pi);
        return bean.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Configuration
    @AutoConfigureAfter(DaoConfiguration.class)  //有顺序
    public static class MyBatisMapperScannerConfig {

        @Bean
        public MapperScannerConfigurer mapperScannerConfig() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
            //扫描mapper位置
            mapperScannerConfigurer.setBasePackage("com.gsn.pm.dao.impl");
            //配置通用mappers
            Properties properties = new Properties();
            //注册自定义mapper
            properties.setProperty("mappers", "com.gsn.pm.dao.MisBaseMapper");
            properties.setProperty("notEmpty", "false");
            properties.setProperty("IDENTITY", "MYSQL");  // 请注意数据库中的主键类型
            mapperScannerConfigurer.setProperties(properties);

            return mapperScannerConfigurer;
        }

    }



}
