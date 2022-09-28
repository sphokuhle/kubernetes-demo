package com.example.kubernetesproject.dto;

import com.example.kubernetesproject.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeDto {

    private long gradeId;

    private String name;

    private String code;

    public GradeDto(Grade grade) {
        if(grade != null) {
            this.gradeId = grade.getGradeId();
            this.name = grade.getName();
            this.code = grade.getCode();
        }

    }
}
