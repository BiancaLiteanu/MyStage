package com.example.matchingapp.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;

    @ElementCollection
    private Set<String> skilluri;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public Set<String> getSkilluri() { return skilluri; }
    public void setSkilluri(Set<String> skilluri) { this.skilluri = skilluri; }
}
