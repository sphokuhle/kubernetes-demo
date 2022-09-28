package com.example.kubernetesproject.entity;

import com.example.kubernetesproject.dto.GradeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GRADE", schema="APP")
public class Grade {

    @Id
    @Column(name = "GRADE_ID")
    private long gradeId;

    @Column(name = "GRADE_NAME")
    private String name;

    @Column(name = "GRADE_CODE")
    private String code;

    public Grade(GradeDto gradeDto){
        this.gradeId = gradeDto.getGradeId();
        this.name = gradeDto.getName();
        this.code = gradeDto.getCode();
    }
}
