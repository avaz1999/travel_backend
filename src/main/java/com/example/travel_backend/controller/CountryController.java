package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.country.CountryEditRequest;
import com.example.travel_backend.dto.country.CountryRequest;
import com.example.travel_backend.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/country")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CountryRequest request){
        return ApiResponse.controller(service.create(request));
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ApiResponse.controller(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?>  getOne(@PathVariable Long id){
        return ApiResponse.controller(service.getOne(id));
    }
    @GetMapping("tur-packet/{id}")
    public ResponseEntity<?> countryTurPackets(@PathVariable Long id){
        return ApiResponse.controller(service.countryTurPackets(id));
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,@RequestBody CountryEditRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
