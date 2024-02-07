package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.AllUserResponse;
import com.example.travel_backend.dto.user.UserEditRequest;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.dto.user.UserResponse;
import com.example.travel_backend.entity.User;
import com.example.travel_backend.exception.security.PasswordNotEqualException;
import com.example.travel_backend.exception.user.UserAlredyExistsException;
import com.example.travel_backend.exception.user.UserNotFoundException;
import com.example.travel_backend.repository.UserRepository;
import com.example.travel_backend.security.JwtService;
import com.example.travel_backend.service.UserService;
import com.example.travel_backend.utils.ResMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final JwtService jwtService;


    @Override
    public ApiResponse<?> getAll() {
        List<User> userList = repository.findAllNotDeleted();
        List<AllUserResponse> userResponses = userList.stream().map(AllUserResponse::toDto).toList();
        return new ApiResponse<>(true, ResMessage.SUCCESS, userResponses);
    }

    @Override
    public ApiResponse<?> getOne(Long id) {
        User user = handleUser(id);
        UserResponse response = UserResponse.toDto(user);
        return new ApiResponse<>(true, ResMessage.SUCCESS, response);
    }


    @Override
    public ApiResponse<?> edit(Long id, UserEditRequest request) {
        User user = handleUser(id);
        User editUser = UserResponse.edit(user, request);
        UserResponse response = UserResponse.toDto(editUser);
        return new ApiResponse<>(true, ResMessage.SUCCESS, response);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        User user = handleUser(id);
        user.setDeleted(true);
        repository.save(user);
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    private User handleUser(Long id) {
        if (id == null) throw new UserNotFoundException();
        User user = repository.findByIdAndDeletedFalse(id);
        if (user == null) throw new UserAlredyExistsException();
        return user;
    }
}
