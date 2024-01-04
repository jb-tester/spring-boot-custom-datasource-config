package com.example.springbootcustomdatasourceconfig.withH2;

import org.springframework.data.repository.CrudRepository;


public interface TeamRepository extends CrudRepository<Team,Integer> {
}
