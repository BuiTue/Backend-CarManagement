package com.example.carmanager.service;

import com.example.carmanager.DTO.CompanyDTO;
import com.example.carmanager.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICompanyService {
    List<CompanyDTO> findAll();

//    Company findByName(String companyName);
}
