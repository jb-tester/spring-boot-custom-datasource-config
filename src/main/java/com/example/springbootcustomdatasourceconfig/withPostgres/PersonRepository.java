package com.example.springbootcustomdatasourceconfig.withPostgres;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    @Query("select e from Person e where e.age > :arg")
    List<Person> customQuery(@Param("arg") int arg);
}
