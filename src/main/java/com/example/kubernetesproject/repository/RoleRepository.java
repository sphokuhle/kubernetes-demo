package com.example.kubernetesproject.repository;

import com.example.kubernetesproject.entity.Role;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>, QuerydslPredicateExecutor<Role> {

}
