package com.dmtree.community.repository;

import com.dmtree.community.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findByEmailContainingIgnoreCase(String email);
}