package com.example.springbootcustomdatasourceconfig.withH2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    private Integer id;
    String title;
    int amount;

    public Team(Integer id, String title, int amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public Team() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Team{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", amount=" + amount +
               '}';
    }
}
