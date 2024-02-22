package com.demo.apirestful.RestAPI.repository;

import com.demo.apirestful.RestAPI.access.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository <User, Long> {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
}
