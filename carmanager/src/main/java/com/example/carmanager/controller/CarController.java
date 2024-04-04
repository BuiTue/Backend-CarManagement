package com.example.carmanager.controller;

import com.example.carmanager.DTO.CarByIdDTO;
import com.example.carmanager.DTO.CarDTO;
import com.example.carmanager.entity.Car;
import com.example.carmanager.form.CarCreateOrUpdateForm;
import com.example.carmanager.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping("api/v1/car/getAll")
    public Page<CarDTO> findAll(Pageable pageable, @RequestParam String search) {
        return carService.findAll(pageable, search);
    }

    @GetMapping("api/v1/car/findById")
    public CarByIdDTO findById(@RequestParam int id) {
        CarByIdDTO car = carService.findById(id);
        return car;
    }

    @PostMapping("api/v1/car")
    public void create(@RequestBody CarCreateOrUpdateForm form) {
        carService.createOrUpdate(form);
    }

    @PutMapping("api/v1/car")
    public void update(@RequestBody CarCreateOrUpdateForm form) {
        carService.createOrUpdate(form);
    }

    @DeleteMapping("api/v1/car")
    public void delete(@RequestParam int id) {
        carService.delete(id);
    }

}
