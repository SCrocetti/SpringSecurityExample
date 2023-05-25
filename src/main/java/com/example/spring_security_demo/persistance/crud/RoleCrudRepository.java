package com.example.spring_security_demo.persistance.crud;

import com.example.spring_security_demo.persistance.entity.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleCrudRepository extends CrudRepository<Role,Integer> {
    @Cacheable
    Optional<Role> findByRolename(String roleName);
}
