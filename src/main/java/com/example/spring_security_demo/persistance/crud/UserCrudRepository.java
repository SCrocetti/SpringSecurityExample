package com.example.spring_security_demo.persistance.crud;

import com.example.spring_security_demo.persistance.entity.User;
import com.example.spring_security_demo.persistance.exception.NotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    @CacheEvict(allEntries = true)
    <S extends User> List<S> saveAll(Iterable<S> entities);

    @Caching(
            evict = {
                    @CacheEvict(key = "#p0.id", condition = "#p0.id != null"),
                    @CacheEvict(key = "#p0.username", condition = "#p0.username != null")
            })
    <S extends User> S save(S entity);

    @Cacheable
    Optional<User> findById(Integer id);
    @Cacheable
    List<User> findAll();

    @Cacheable
    default User getById(Integer id) {
        var optionalUser = findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(User.class, id);
        }
        if (!optionalUser.get().isEnabled()) {
            throw new NotFoundException(User.class, id);
        }
        return optionalUser.get();
    }

    @Cacheable
    Optional<User> findByUsername(String username);
    @Cacheable
    Optional<User> findByEmail(String email);
    @Cacheable
    Optional<List<User>> findByFirstNameAndLastName(String firstName, String lastName);
}
