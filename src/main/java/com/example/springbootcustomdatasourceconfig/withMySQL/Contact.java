package com.example.springbootcustomdatasourceconfig.withMySQL;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "email")
    private String email;

    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(String firstname, String lastname, String telephone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
               "id=" + id +
               ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", telephone='" + telephone + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(firstname, contact.firstname) && Objects.equals(lastname, contact.lastname) && Objects.equals(telephone, contact.telephone) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(firstname);
        result = 31 * result + Objects.hashCode(lastname);
        result = 31 * result + Objects.hashCode(telephone);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}
