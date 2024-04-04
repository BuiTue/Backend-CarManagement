package com.example.carmanager.service;

import com.example.carmanager.DTO.CarByIdDTO;
import com.example.carmanager.DTO.CarDTO;
import com.example.carmanager.DTO.CarLogin;
import com.example.carmanager.entity.Car;
import com.example.carmanager.form.CarCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ICarService extends UserDetailsService {

    Page<CarDTO> findAll(Pageable pageable, String search);

    void createOrUpdate(CarCreateOrUpdateForm form);

    void delete(int id);

    CarByIdDTO findById(int id);

    CarLogin findByCarName(String carName);
}

