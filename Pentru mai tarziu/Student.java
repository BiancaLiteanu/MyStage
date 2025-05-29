package com.example.matchingapp.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String email;
    private String universitate;
    private String parola;

    @ElementCollection
    @CollectionTable(name = "student_skilluri", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill")
    private Set<String> skilluri;

    public Student() {}

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversitate() {
        return universitate;
    }

    public void setUniversitate(String universitate) {
        this.universitate = universitate;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Set<String> getSkilluri() {
        return skilluri;
    }

    public void setSkilluri(Set<String> skilluri) {
        this.skilluri = skilluri;
    }
}
