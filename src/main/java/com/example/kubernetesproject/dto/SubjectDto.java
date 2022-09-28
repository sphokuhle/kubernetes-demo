package com.example.kubernetesproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDto {

    private long subjectId;

    private String subjectName;

    private String subjectCode;

    private StreamDto stream;
}
