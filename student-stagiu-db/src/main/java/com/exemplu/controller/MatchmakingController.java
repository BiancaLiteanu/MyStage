package com.exemplu.controller;

import com.exemplu.service.MatchmakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MatchmakingController {

    @Autowired
    private MatchmakingService matchmakingService;

    @GetMapping("/potriviri/{studentId}")
    public Map<String, Integer> gasestePotriviri(@PathVariable Long studentId) {
        return matchmakingService.potriviriPentruStudent(studentId);
    }
}
