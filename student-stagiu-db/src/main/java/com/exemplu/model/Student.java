package com.exemplu.model;

import jakarta.persistence.*;
import java.util.Map;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @ElementCollection
    private Map<String, Integer> skilluri;

    public Student() {}

    public Student(String nume, Map<String, Integer> skilluri) {
        this.nume = nume;
        this.skilluri = skilluri;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Map<String, Integer> getSkilluri() {
        return skilluri;
    }

    public void setSkilluri(Map<String, Integer> skilluri) {
        this.skilluri = skilluri;
    }
}
