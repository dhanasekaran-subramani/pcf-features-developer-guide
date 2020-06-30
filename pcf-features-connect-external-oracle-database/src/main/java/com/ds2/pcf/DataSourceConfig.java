package com.ds2.pcf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@Slf4j
public class DataSourceConfig {

    @Value("${db.defaultTransactionTimeout:2}")
    private int defaultTransactionTimeoutInSecond;

    private final DataSource dataSource;

    //public DataSourceConfig() {}

    /**
     * dataSource bean will be created by Spring.
     * Only we need specify the properties.
     * spring.datasource.url=
     * spring.datasource.username=
     * spring.datasource.password=
     * spring.datasource.driver-class-name=
     * spring.datasource.hikari.connection-timeout=
     * spring.datasource.hikari.maximum-pool-size
     * Note: property name should be started spring.datasource
     * so that spring will detect these are related to datasource properties.
     */
    public DataSourceConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return transaction manager to use.
     */
    @Bean
    public PlatformTransactionManager txManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        // timeout is in seconds
        transactionManager.setDefaultTimeout(defaultTransactionTimeoutInSecond);
        return transactionManager;
    }

    /**
     * Translates Application exceptions to Spring Data Access Exceptions
     */
    @Bean
    public BeanPostProcessor exceptionTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
