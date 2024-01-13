package com.example.travel_backend.controller;

import com.example.travel_backend.service.TravelPlaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/travel")
public class TravelPlaceController {
    private final TravelPlaceService service;

    public TravelPlaceController(TravelPlaceService service) {
        this.service = service;
    }
}
