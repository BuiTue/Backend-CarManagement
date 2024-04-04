package com.example.carmanager.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="car")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="car_name", nullable = false)
    private String carName;
    @Column(name = "`password`")
    private String password;

    @Column(name="license_plate",nullable = false,unique = true)
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name="company_id",nullable = false)
    private Company company;

}
