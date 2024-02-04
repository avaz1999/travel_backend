package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.nutritioncategory.NutritionCategoryRequest;
import com.example.travel_backend.service.NutritionCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/nutrition")
public class NutritionCategoryController {
    private final NutritionCategoryService service;

    public NutritionCategoryController(NutritionCategoryService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid NutritionCategoryRequest request){
        return ApiResponse.controller(service.create(request));
    }
    @GetMapping
    private ResponseEntity<?> getAll(){
        return ApiResponse.controller(service.getAll());
    }
    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,@RequestBody NutritionCategoryRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
