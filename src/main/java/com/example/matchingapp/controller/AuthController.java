package com.example.matchingapp.controller;

import com.example.matchingapp.model.LoginRequest;
import com.example.matchingapp.model.Utilizator;
import com.example.matchingapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String rezultat = authService.autentificare(loginRequest);
        if (rezultat.startsWith("Login reușit")) {
            return ResponseEntity.ok(rezultat);
        } else {
            return ResponseEntity.status(401).body(rezultat);
        }


    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Utilizator utilizator) {
        String rezultat = authService.register(utilizator);
        if (rezultat.startsWith("Utilizator înregistrat")) {
            return ResponseEntity.ok(rezultat);
        } else {
            return ResponseEntity.status(400).body(rezultat);
        }
    }



}
