package com.example.carmanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="company")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="company_name", nullable = false, unique = true)
    private String companyName;

    @OneToMany(mappedBy = "company")
    private List<Car> cars;

}
