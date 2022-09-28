package com.example.kubernetesproject.repository;

import com.example.kubernetesproject.dto.GradeDto;
import com.example.kubernetesproject.entity.Grade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GradeRepository extends PagingAndSortingRepository<Grade, Long>, QuerydslPredicateExecutor<Grade>
        /*,QuerydslPredicateExecutor<Grade>, QuerydslBinderCustomizer<QGrade>*/ {

    @Query(value = "Select new com.example.kubernetesproject.dto.GradeDto(g) FROM Grade g Order By g.gradeId")
    List<GradeDto> getAllGrades();
}
