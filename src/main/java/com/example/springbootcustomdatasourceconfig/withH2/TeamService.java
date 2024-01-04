package com.example.springbootcustomdatasourceconfig.withH2;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {


    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public void populateTeam(){
        List<Team> teams = List.of(
                new Team(1,"firstTeam",8),
                new Team(2,"secondTeam",7),
                new Team(3,"thirdTeam",9)
        );
        teamRepository.saveAll(teams);

    }
    public void displayAllTeams(){
        System.out.println("+++++++++++++++ all teams: +++++++++++++++");
        for (Team team : teamRepository.findAll()) {
            System.out.println(team);
        }
    }
}
