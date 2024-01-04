package com.example.springbootcustomdatasourceconfig;

import com.example.springbootcustomdatasourceconfig.withH2.TeamService;
import com.example.springbootcustomdatasourceconfig.withMySQL.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCustomDatasourceConfigApplication implements CommandLineRunner {

    private final TeamService teamService;
    private final ContactService contactService;

    public SpringBootCustomDatasourceConfigApplication(TeamService teamService, ContactService contactService) {
        this.teamService = teamService;
        this.contactService = contactService;
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
        System.out.println("=======================================================");

    }
}
