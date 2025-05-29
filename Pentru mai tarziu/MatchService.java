package com.example.matchingapp.service;

import com.example.matchingapp.exception.ResourceNotFoundException;
import com.example.matchingapp.model.Stagiu;
import com.example.matchingapp.model.Student;
import com.example.matchingapp.repository.StagiuRepository;
import com.example.matchingapp.repository.StudentRepository;
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

    // Returnează lista de stagii compatibile cu skill-urile unui student
    public List<Stagiu> matchStagiiForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Studentul cu ID-ul " + studentId + " nu a fost găsit."));

        Set<String> skilluriStudent = student.getSkilluri();

        return stagiuRepository.findAll().stream()
                .filter(stagiu -> skilluriStudent.containsAll(stagiu.getSkilluriNecesare()))
                .collect(Collectors.toList());
    }

    // Returnează lista de studenți compatibili cu un stagiu pe baza skillurilor necesare
    public List<Student> matchStudentsForStagiu(Long stagiuId) {
        Stagiu stagiu = stagiuRepository.findById(stagiuId)
                .orElseThrow(() -> new ResourceNotFoundException("Stagiul cu ID-ul " + stagiuId + " nu a fost găsit."));

        Set<String> skilluriNecesare = stagiu.getSkilluriNecesare();

        return studentRepository.findAll().stream()
                .filter(student -> student.getSkilluri().containsAll(skilluriNecesare))
                .collect(Collectors.toList());
    }
}
