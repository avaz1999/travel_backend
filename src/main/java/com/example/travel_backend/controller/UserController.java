package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.user.UserEditRequest;
import com.example.travel_backend.dto.user.UserRequest;
import com.example.travel_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN')")
    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(service.getAll());
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ApiResponse.controller(service.getOne(id));
    }

    @PreAuthorize("hasAnyAuthority('DEVELOPER','OPERATOR','ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody UserEditRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER','OPERATOR','ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
