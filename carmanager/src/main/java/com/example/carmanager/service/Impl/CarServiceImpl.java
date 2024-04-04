package com.example.carmanager.service.Impl;

import com.example.carmanager.DTO.CarByIdDTO;
import com.example.carmanager.DTO.CarDTO;
import com.example.carmanager.DTO.CarLogin;
import com.example.carmanager.entity.Car;
import com.example.carmanager.form.CarCreateOrUpdateForm;
import com.example.carmanager.repository.ICarRepository;
import com.example.carmanager.repository.ICompanyRepository;
import com.example.carmanager.service.ICarService;
import com.example.carmanager.specification.CustomCarSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICompanyRepository companyRepository;

//    @Override
//    public Page<CarDTO> findAll(Pageable pageable) {
//        Page<Car> cars = carRepository.findAll(pageable);// lay ds entity
//        Page<CarDTO> carDTOPage = cars.map(new Function<Car, CarDTO>() {
//            @Override
//            public CarDTO apply(Car car) {
//                CarDTO carDTO = modelMapper.map(car, CarDTO.class);
//                return carDTO;
//            }
//        });
//        return carDTOPage;
//    }

    @Override
    public Page<CarDTO> findAll(Pageable pageable, String search) {
        search =search.trim();
        CustomCarSpecification custom = new CustomCarSpecification("carName",search);
        CustomCarSpecification custom1= new CustomCarSpecification("licensePlate",search);
        CustomCarSpecification custom2= new CustomCarSpecification("companyName",search);
        Specification<Car> where = Specification.where(custom.or(custom1).or(custom2));
        Page<Car> cars = carRepository.findAll(where,pageable);
        Page<CarDTO> carDTOS = cars.map(new Function<Car, CarDTO>() {
            @Override
            public CarDTO apply(Car car) {
                CarDTO carDTOS = modelMapper.map(car,CarDTO.class);
                return carDTOS;
            }
        });
        return carDTOS;
    }

    @Override
    public void createOrUpdate(CarCreateOrUpdateForm form) {
        Car car = modelMapper.map(form, Car.class);
        carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarByIdDTO findById(int id) {
        Optional<Car> optional = carRepository.findById(id);
        if (!optional.isPresent())
            return null;
        Car car = optional.get();
        CarByIdDTO carByIdDTO = modelMapper.map(car, CarByIdDTO.class);
        return carByIdDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Car car = carRepository.findByCarName(username);
        if (Objects.isNull(car))
            throw  new UsernameNotFoundException("Username not found");
        else{
            return new User(car.getCarName(), car.getPassword(), AuthorityUtils.createAuthorityList("user"));
        }

    }

    @Override
    public CarLogin findByCarName(String carName) {
        Car car = carRepository.findByCarName(carName);
        CarLogin carLogin = modelMapper.map(car, CarLogin.class);
        return carLogin;

    }
}
