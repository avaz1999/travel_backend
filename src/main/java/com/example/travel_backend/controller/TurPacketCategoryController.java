package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.turpacketcategory.TurPacketCategoryRequest;
import com.example.travel_backend.service.TurPacketCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tur-packet/category")
public class TurPacketCategoryController {
    private final TurPacketCategoryService service;
    public TurPacketCategoryController(TurPacketCategoryService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TurPacketCategoryRequest request){
        return ApiResponse.controller(service.create(request));
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(service.getAll());
    }
    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,@RequestBody TurPacketCategoryRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
