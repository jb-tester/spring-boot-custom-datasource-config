package com.example.springbootcustomdatasourceconfig.withH2;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeamRepository extends CrudRepository<Team,Integer> {
    List<Team> findByTitle(String title);

    List<Team> findByAmountGreaterThan(int value);
}

