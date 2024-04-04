package com.example.carmanager.DTO;

import lombok.Data;

@Data
public class CarByIdDTO {
    private int id;
    private String carName;
    private String licensePlate;
    private String companyId;
}
