package com.example.kubernetesproject.repository;

import com.example.kubernetesproject.entity.UserRole;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>, QuerydslPredicateExecutor<UserRole> {
//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO security.user_role values(nextval('security.user_role_seq'), :user_Id, role_Id)", nativeQuery = true)
//    UserRole insert(Long userId, Long roleId);
}
