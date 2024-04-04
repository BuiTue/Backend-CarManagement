package com.example.carmanager.service.Impl;

import com.example.carmanager.DTO.CompanyDTO;
import com.example.carmanager.entity.Company;
import com.example.carmanager.repository.ICompanyRepository;
import com.example.carmanager.service.ICompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CompanyDTO> findAll() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = modelMapper.map(companies,new TypeToken<List<CompanyDTO>>(){}.getType());
        return companyDTOS;
    }

//    @Override
//    public Company findByName(String companyName) {
//        return companyRepository.findByName(companyName);
//    }
}
