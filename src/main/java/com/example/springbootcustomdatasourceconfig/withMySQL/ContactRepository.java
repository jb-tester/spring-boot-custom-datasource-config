package com.example.springbootcustomdatasourceconfig.withMySQL;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ContactRepository extends CrudRepository<Contact,Integer> {

    @Override
    Iterable<Contact> findAll();

    List<Contact> findByLastname(String lastName);

}
