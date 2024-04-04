package com.example.carmanager.repository;

import com.example.carmanager.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car,Integer>, JpaSpecificationExecutor<Car> {
    Car findByCarName(String carName);
}
