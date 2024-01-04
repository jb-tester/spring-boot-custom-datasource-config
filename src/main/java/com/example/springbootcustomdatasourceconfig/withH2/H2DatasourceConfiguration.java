package com.example.springbootcustomdatasourceconfig.withH2;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class H2DatasourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("aaa.h2")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource h2DataSource() {
        return h2DataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}