package com.example.springbootcustomdatasourceconfig.withMySQL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.example.springbootcustomdatasourceconfig.withMySQL",
  entityManagerFactoryRef = "mysqlEntityManagerFactory",
  transactionManagerRef = "mysqlTransactionManager"
)
public class MySqlJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
      @Qualifier("mysqlDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages("com.example.springbootcustomdatasourceconfig.withMySQL")
          .build();
    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager(
      @Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(mysqlEntityManagerFactory.getObject()));
    }
}