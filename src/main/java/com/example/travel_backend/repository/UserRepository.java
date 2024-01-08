package com.example.travel_backend.repository;

import com.example.travel_backend.entity.User;
import com.example.travel_backend.repository.base.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    boolean existsByUsernameAndDeletedFalse(String username);
}
