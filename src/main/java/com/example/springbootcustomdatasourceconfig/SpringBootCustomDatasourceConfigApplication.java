package com.example.springbootcustomdatasourceconfig;

import com.example.springbootcustomdatasourceconfig.withH2.TeamService;
import com.example.springbootcustomdatasourceconfig.withMySQL.ContactService;
import com.example.springbootcustomdatasourceconfig.withPostgres.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCustomDatasourceConfigApplication implements CommandLineRunner {

    private final TeamService teamService;
    private final ContactService contactService;
    private final PersonService personService;

    public SpringBootCustomDatasourceConfigApplication(TeamService teamService, ContactService contactService, PersonService personService) {
        this.teamService = teamService;
        this.contactService = contactService;
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCustomDatasourceConfigApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===============  test H2 datasource: ==============");
        teamService.populateTeam();
        teamService.displayAllTeams();
        System.out.println("===============  test MySQL datasource: ==============");
        contactService.displayAllTeams();
        System.out.println("===============  test Postgres datasource: ==============");
        personService.displayAllPerson();
        System.out.println("=======================================================");

    }
}
