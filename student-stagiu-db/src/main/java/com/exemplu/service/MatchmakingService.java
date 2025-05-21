package com.exemplu.service;

import com.exemplu.model.Student;
import com.exemplu.model.Stagiu;
import com.exemplu.repository.StagiuRepository;
import com.exemplu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchmakingService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StagiuRepository stagiuRepo;

    public Map<String, Integer> potriviriPentruStudent(Long studentId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        if (studentOpt.isEmpty()) return Collections.emptyMap();

        Student student = studentOpt.get();
        List<Stagiu> stagii = stagiuRepo.findAll();

        Map<String, Integer> scoruri = new HashMap<>();
        for (Stagiu stagiu : stagii) {
            int scor = calculeazaScor(student, stagiu);
            scoruri.put(stagiu.getTitlu(), scor);
        }

        return scoruri;
    }

    private int calculeazaScor(Student student, Stagiu stagiu) {
        int scor = 0;
        Map<String, Integer> skilluriStudent = student.getSkilluri();
        Map<String, Integer> cerinteStagiu = stagiu.getCerinte();

        for (Map.Entry<String, Integer> cerinta : cerinteStagiu.entrySet()) {
            String skill = cerinta.getKey();
            int nivelNecesar = cerinta.getValue();

            int nivelStudent = skilluriStudent.getOrDefault(skill, 0);
            if (nivelStudent >= nivelNecesar) {
                scor += nivelStudent - nivelNecesar + 1;
            }
        }

        return scor;
    }
}
