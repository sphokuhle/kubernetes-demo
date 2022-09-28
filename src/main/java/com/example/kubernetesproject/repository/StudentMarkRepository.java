package com.example.kubernetesproject.repository;



import com.example.kubernetesproject.entity.StudentMark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentMarkRepository extends PagingAndSortingRepository<StudentMark, Long>, QuerydslPredicateExecutor<StudentMark> {

    @Query(value = "Select sm FROM StudentMark sm")
    List<StudentMark> getStudentMarks();
}
