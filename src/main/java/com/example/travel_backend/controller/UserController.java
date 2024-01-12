package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRequest request){
        return ApiResponse.controller(service.create(request));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(service.getAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ApiResponse.controller(service.getOne(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody UserRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
