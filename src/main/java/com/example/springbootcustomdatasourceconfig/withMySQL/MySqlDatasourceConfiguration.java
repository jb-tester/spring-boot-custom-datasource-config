package com.example.springbootcustomdatasourceconfig.withMySQL;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySqlDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mysqlDataSource() {
        return mysqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    // another way to define the custom datasource
    // https://youtrack.jetbrains.com/issue/IDEA-346177
   /* @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().type(MysqlDataSource.class).build();
    }*/
}