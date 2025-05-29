package com.example.matchingapp.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stagii")
public class Stagiu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlu;
    private String companie;
    private String descriere;

    @ElementCollection
    @CollectionTable(name = "stagiu_skilluri", joinColumns = @JoinColumn(name = "stagiu_id"))
    @Column(name = "skill")
    private Set<String> skilluriNecesare;

    public Stagiu() {}

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Set<String> getSkilluriNecesare() {
        return skilluriNecesare;
    }

    public void setSkilluriNecesare(Set<String> skilluriNecesare) {
        this.skilluriNecesare = skilluriNecesare;
    }
}
