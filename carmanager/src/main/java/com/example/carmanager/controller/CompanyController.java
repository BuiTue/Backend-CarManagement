package com.example.carmanager.controller;

import com.example.carmanager.DTO.CompanyDTO;
import com.example.carmanager.entity.Company;
import com.example.carmanager.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @GetMapping("api/v1/company/getAll")
    List<CompanyDTO> findAll(){
        return companyService.findAll();
    }

//    @GetMapping("api/v1/company/findByName")
//    public Company findByName(@RequestParam String companyName){
//        return companyService.findByName(companyName);
//    }

}
