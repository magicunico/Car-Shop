package com.example.demo.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){return carRepository.findAll();}

    public void addCar(Car car){carRepository.save(car);}

    public void deleteCar(Car car){carRepository.delete(car);}
}
