package com.exemplu.controller;

import com.exemplu.model.Student;
import com.exemplu.model.Stagiu;
import com.exemplu.repository.StudentRepository;
import com.exemplu.repository.StagiuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentStagiuController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StagiuRepository stagiuRepo;

    @PostMapping("/students")
    public Student adaugaStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PostMapping("/stagii")
    public Stagiu adaugaStagiu(@RequestBody Stagiu stagiu) {
        return stagiuRepo.save(stagiu);
    }
}
