package com.example.matchingapp.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Stagiu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titlu;

    @ElementCollection
    private Set<String> skilluriNecesare;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }
    public Set<String> getSkilluriNecesare() { return skilluriNecesare; }
    public void setSkilluriNecesare(Set<String> skilluriNecesare) { this.skilluriNecesare = skilluriNecesare; }
}
