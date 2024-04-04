package com.example.carmanager.controller;

import com.example.carmanager.DTO.CarLogin;
import com.example.carmanager.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private ICarService carService;

    @GetMapping("api/v1/login")
    public CarLogin login (Principal principal){
        String carName = principal.getName();
        CarLogin carLogin = carService.findByCarName(carName);
        return carLogin;
    }

}
