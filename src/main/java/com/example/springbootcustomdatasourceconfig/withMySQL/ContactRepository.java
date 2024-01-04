package com.example.springbootcustomdatasourceconfig.withMySQL;

import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<Contact,Integer> {
}
