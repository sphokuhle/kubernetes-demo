package com.example.kubernetesproject.repository;

import com.example.kubernetesproject.entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long>, QuerydslPredicateExecutor<Subject> {
    @Query(value = "Select s From Subject s")
    List<Subject> getAllSubjects();
}
