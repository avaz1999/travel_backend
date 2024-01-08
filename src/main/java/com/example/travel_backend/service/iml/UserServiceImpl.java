package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.entity.User;
import com.example.travel_backend.exception.user.UserAlredyExistsException;
import com.example.travel_backend.exception.user.UserNotFoundException;
import com.example.travel_backend.repository.UserRepository;
import com.example.travel_backend.service.UserService;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApiResponse<?> create(UserRequest request) {
        if (repository.existsByUsernameAndDeletedFalse(request.getUsername())) throw  new UserAlredyExistsException();
        User user = User.create(request);
        repository.save(user);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ApiResponse<?> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        return null;
    }

    @Override
    public ApiResponse<?> edit(Long id, UserRequest request) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        return null;
    }
}
