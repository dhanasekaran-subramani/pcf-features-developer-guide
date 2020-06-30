package com.ds2.pcf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.sql.DataSource;


@Configuration
public class DataSourceHikariConfig extends HikariConfig {

   // This configuration connect  database using secure connection TLS1.2 (mutual authentication)
    // enable DatasourceConfig or DataSourceHikariConfig not both
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("<empty>"); //specify jdbc url
        config.setUsername("<empty>"); //specify username
        config.setPassword("<empty>"); //specify password
        config.addDataSourceProperty("javax.net.ssl.keyStore", "keyastore.jks"); // specify keystore.jks file location absolute path
        config.addDataSourceProperty("javax.net.ssl.keyStorePassword", "<empty>"); //specify keystore password
        config.addDataSourceProperty("javax.net.debug","ssl:handshake");///ssl:handshake // for debug
        config.addDataSourceProperty("javax.net.ssl.trustStore","truststore.jks"); //specify truststore.jks file location absolute path
        config.addDataSourceProperty("javax.net.ssl.trustStorePassword","<empty>"); //specify truststore password
        config.addDataSourceProperty("https.protocols","TLSv1.2");
        return new HikariDataSource(config);
    }


    /**
     * Translates Application exceptions to Spring Data Access Exceptions
     */
    @Bean
    public BeanPostProcessor exceptionTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
