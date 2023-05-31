package com.example.spring_security_demo.persistance.crud;

import com.example.spring_security_demo.persistance.entity.User;
import com.example.spring_security_demo.persistance.entity.UserRole;
import com.example.spring_security_demo.persistance.entity.UserRolePk;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleCrudRepository extends CrudRepository<UserRole, UserRolePk> {
    @Cacheable
    Optional<UserRole> findById(UserRolePk id);
}
