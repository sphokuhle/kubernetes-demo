package com.example.kubernetesproject.dto;

import com.example.kubernetesproject.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private long studentId;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String username;

    private String password;

    private GradeDto grade;

    private boolean active;

    private Date registrationDate;

    public StudentDto(Student student){
        this.studentId = student.getStudentId();
        this.name = student.getUser().getFirstName();
        this.surname = student.getUser().getLastName();
        this.grade = new GradeDto(student.getGrade());
        this.active = student.getActive();
        this.email = student.getUser().getEmail();
        this.phoneNumber = student.getUser().getPhoneNumber();
        this.registrationDate = student.getRegistrationDate();
        this.username = student.getUser().getUsername();
    }

}
