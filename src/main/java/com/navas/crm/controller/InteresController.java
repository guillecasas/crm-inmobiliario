package com.navas.crm.controller;

import com.navas.crm.dto.InteresRequest;
import com.navas.crm.model.Interes;
import com.navas.crm.service.InteresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intereses")
public class InteresController {

    private final InteresService interesService;

    public InteresController(InteresService interesService) {
        this.interesService = interesService;
    }

    @GetMapping
    public List<Interes> getIntereses() {
        return interesService.getIntereses();
    }

    @PostMapping
    public Interes addInteres(@RequestBody InteresRequest request) {
        return interesService.addInteres(request);
    }
}