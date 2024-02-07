package com.example.travel_backend.repository;

import com.example.travel_backend.entity.User;
import com.example.travel_backend.repository.base.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    boolean existsByUsernameAndDeletedFalse(String username);
    boolean existsByEmailAndDeletedFalse(String email);
    Optional<User> findByUsernameAndDeletedFalse(String username);
    User findByEmailAndDeletedFalse(String email);
}
