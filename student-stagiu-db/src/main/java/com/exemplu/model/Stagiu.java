package com.exemplu.model;

import jakarta.persistence.*;
import java.util.Map;

@Entity
public class Stagiu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlu;

    @ElementCollection
    private Map<String, Integer> cerinte;

    public Stagiu() {}

    public Stagiu(String titlu, Map<String, Integer> cerinte) {
        this.titlu = titlu;
        this.cerinte = cerinte;
    }

    public Long getId() {
        return id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Map<String, Integer> getCerinte() {
        return cerinte;
    }

    public void setCerinte(Map<String, Integer> cerinte) {
        this.cerinte = cerinte;
    }
}
