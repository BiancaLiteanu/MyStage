package com.example.matchingapp.service;

import com.example.matchingapp.model.LoginRequest;
import com.example.matchingapp.model.Utilizator;
import com.example.matchingapp.repository.UtilizatorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UtilizatorRepository utilizatorRepository;

    public AuthService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    public String autentificare(LoginRequest loginRequest) {
        // 🔁 Căutare după EMAIL
        Utilizator user = utilizatorRepository.findByEmail(loginRequest.getEmail());

        if (user != null && user.getParola().equals(loginRequest.getParola())) {
            return "Login reușit ca " + user.getRol();
        } else {
            return "Email sau parolă greșită!";
        }
    }

    public String register(Utilizator utilizator) {
        if (utilizatorRepository.findByUsername(utilizator.getUsername()) != null) {
            return "Username deja există!";
        }

        utilizatorRepository.save(utilizator);
        return "Utilizator înregistrat cu succes!";
    }
}
