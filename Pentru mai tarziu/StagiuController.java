package com.example.matchingapp.controller;

import com.example.matchingapp.model.Stagiu;
import com.example.matchingapp.repository.StagiuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagii")
public class StagiuController {
    private final StagiuRepository stagiuRepository;
    public StagiuController(StagiuRepository stagiuRepository) {
        this.stagiuRepository = stagiuRepository;
    }

    @PostMapping
    public Stagiu create(@RequestBody Stagiu stagiu) {
        return stagiuRepository.save(stagiu);
    }

    @GetMapping
    public List<Stagiu> all() {
        return stagiuRepository.findAll();
    }
}
