package com.example.springbootcustomdatasourceconfig.withH2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
  basePackages = "com.example.springbootcustomdatasourceconfig.withH2",
  entityManagerFactoryRef = "h2EntityManagerFactory",
  transactionManagerRef = "h2TransactionManager"
)
public class H2JpaConfiguration {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
      @Qualifier("h2DataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages("com.example.springbootcustomdatasourceconfig.withH2")
          .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager h2TransactionManager(
      @Qualifier("h2EntityManagerFactory") LocalContainerEntityManagerFactoryBean h2EntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(h2EntityManagerFactory.getObject()));
    }
}