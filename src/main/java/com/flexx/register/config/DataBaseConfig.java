package com.flexx.register.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataBaseConfig {

    private static final String ERROR = "Fail on connect to database!";

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Bean
    public DataSource dataSource() throws Exception {
        try {
            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(driverName);
            dataSourceBuilder.url(url);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
            return dataSourceBuilder.build();
        } catch (Exception ex) {
            log.error(ERROR);
            throw new Exception(ERROR, ex);
        }

    }

}
