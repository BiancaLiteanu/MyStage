package com.example.matchingapp.repository;

import com.example.matchingapp.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
    Utilizator findByUsername(String username);
    Utilizator findByEmail(String email);
}
