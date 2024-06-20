package com.example.springbootcustomdatasourceconfig.withPostgres;

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
  basePackages = "com.example.springbootcustomdatasourceconfig.withPostgres",
  entityManagerFactoryRef = "postgresEntityManagerFactory",
  transactionManagerRef = "postgresTransactionManager"
)
public class PostgresJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
      @Qualifier("postgresDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages("com.example.springbootcustomdatasourceconfig.withPostgres")
          .build();
    }

    @Bean
    public PlatformTransactionManager postgresTransactionManager(
      @Qualifier("postgresEntityManagerFactory") LocalContainerEntityManagerFactoryBean postgresEMFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(postgresEMFactory.getObject()));
    }
}