package com.example.carmanager.form;

import lombok.Data;

@Data
public class CarCreateOrUpdateForm {

    private int id;
    private String carName;
    private String licensePlate;
    private String companyId;
}
