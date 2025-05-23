package com.autosyn.user_service.repository;

import com.autosyn.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

//    boolean existsByEmail(String email);
//
//    Optional<User> findByEmailAndPassword(String email, String password);

}
