package com.example.matchingapp.controller;

import com.example.matchingapp.model.Stagiu;
import com.example.matchingapp.model.Student;
import com.example.matchingapp.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    private final MatchService matchService;
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/student/{id}")
    public List<Stagiu> match(@PathVariable Long id) {
        return matchService.matchStagiiForStudent(id);
    }
    @GetMapping("/stagiu/{id}")
    public List<Student> matchStudents(@PathVariable Long id) {
        return matchService.matchStudentsForStagiu(id);
    }


}
