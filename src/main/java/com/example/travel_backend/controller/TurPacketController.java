package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.dto.turpacket.TurPacketEditRequest;
import com.example.travel_backend.dto.turpacket.TurPacketRequest;
import com.example.travel_backend.service.TurPacketService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tur-packet")
public class TurPacketController {
    private final TurPacketService service;

    public TurPacketController(TurPacketService service) {
        this.service = service;
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @PostMapping("create/{countryId}")
    public ResponseEntity<?> create(@PathVariable Long countryId, @RequestBody @Valid TurPacketRequest request){
        return ApiResponse.controller(service.create(countryId,request));
    }
    @GetMapping("all")
    public ResponseEntity<?> getAll(Pageable pageable){
        return ApiResponse.controller(service.getAll(pageable));
    }
    @GetMapping("one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ApiResponse.controller(service.getOne(id));
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,@RequestBody TurPacketEditRequest request){
        return ApiResponse.controller(service.edit(id,request));
    }
    @PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN','OPERATOR')")
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ApiResponse.controller(service.delete(id));
    }
}
