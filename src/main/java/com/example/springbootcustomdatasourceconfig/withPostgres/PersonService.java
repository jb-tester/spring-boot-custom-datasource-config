package com.example.springbootcustomdatasourceconfig.withPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void displayAllPerson() {
        personRepository.findAll().iterator().forEachRemaining(System.out::println);
    }

    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> findPersonsOlderThan(int age) {
        return personRepository.customQuery(age);
    }
}