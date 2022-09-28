package com.example.kubernetesproject.controller;

import com.example.kubernetesproject.dto.GradeDto;
import com.example.kubernetesproject.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grade/")
public class GradeController {
    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("all")
    @PreAuthorize("hasAnyAuthority('student_authorization', 'teacher_authorization')")
    List<GradeDto> getGrades() {
        return gradeRepository.getAllGrades();
    }
}
