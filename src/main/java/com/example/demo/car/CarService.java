package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

     List<Car> getCars(){return carRepository.findAll();}

     void addCar(Car car){carRepository.save(car);}

     void deleteCar(Long id){
        Car car=carRepository.findById(id).get();
        car.setNonactive();
        carRepository.save(car);
    }

    void updateCar(CarDTO carDTO){
        Car car = carRepository.findById(carDTO.getId()).orElseThrow(()->new IllegalArgumentException("Car not found"));

        car.setBody(carDTO.getBody());
        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setPrice(carDTO.getPrice());
        car.setGearbox(carDTO.getGearbox());
        car.setWarehouse(carDTO.getWarehouse());
        carRepository.save(car);
    }

    List<Car> getActive(){
        return carRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }

    Car getCar(Long id){
        return carRepository.findById(id).get();
    }

}
