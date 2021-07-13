package com.virgonia.spring5.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/11 11:36
 */
@Configuration
@ComponentScan(basePackages = {"com.virgonia.spring5.transaction"})
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")

public class TransactionConfig {

/*    @Value("#{prop.driverClassName}")
    private String driverClassName;

    @Value("#{prop.url}")
    private String url;

    @Value("#{prop.username}")
    private String username;

    @Value("#{prop.password}")
    private String password;*/

    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("917816");
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }





}
