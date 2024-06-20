package com.example.springbootcustomdatasourceconfig.withPostgres;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "person", schema = "jbtests")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
    @SequenceGenerator(name = "person_id_gen", sequenceName = "person_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 36)
    private String firstName;

    @Column(name = "last_name", length = 36)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @ColumnDefault("false")
    @Column(name = "retired")
    private Boolean retired;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getRetired() {
        return retired;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", retired=" + retired +
               '}';
    }

    /*
 TODO [Reverse Engineering] create field to map the 'sex' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @ColumnDefault("'unknown'")
    @Column(name = "sex", columnDefinition = "sex_enum")
    private Object sex;
*/
}