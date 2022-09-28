package com.example.kubernetesproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentMarkDto {

    private long studentMarkId;

    private SubjectDto subjectDto;

    private StudentDto student;

    private MarkDto mark;
}
