package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

     List<Car> getCars(){return carRepository.findAll();}

     void addCar(Car car){carRepository.save(car);}

     void deleteCar(Long id){carRepository.deleteById(id);}
}
