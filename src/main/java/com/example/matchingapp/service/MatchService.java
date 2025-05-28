package com.example.matchingapp.service;

import com.example.matchingapp.model.Student;
import com.example.matchingapp.model.Stagiu;
import com.example.matchingapp.repository.StudentRepository;
import com.example.matchingapp.repository.StagiuRepository;
import com.example.matchingapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private final StudentRepository studentRepository;
    private final StagiuRepository stagiuRepository;

    public MatchService(StudentRepository studentRepository, StagiuRepository stagiuRepository) {
        this.studentRepository = studentRepository;
        this.stagiuRepository = stagiuRepository;
    }

    public List<Stagiu> matchStagiiForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Set<String> skilluri = student.getSkilluri();
        return stagiuRepository.findAll().stream()
            .filter(s -> skilluri.containsAll(s.getSkilluriNecesare()))
            .collect(Collectors.toList());
    }
    public List<Student> matchStudentsForStagiu(Long stagiuId) {
        Stagiu stagiu = stagiuRepository.findById(stagiuId)
                .orElseThrow(() -> new ResourceNotFoundException("Stagiu not found"));

        Set<String> skilluriNecesare = stagiu.getSkilluriNecesare();

        return studentRepository.findAll().stream()
                .filter(student -> student.getSkilluri().containsAll(skilluriNecesare))
                .collect(Collectors.toList());
    }


}
