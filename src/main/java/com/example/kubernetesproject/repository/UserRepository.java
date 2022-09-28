package com.example.kubernetesproject.repository;


import com.example.kubernetesproject.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, QuerydslPredicateExecutor<User> {
    Optional<User> findByUsername(String username);
}
