package com.example.demo.car;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Car> getAll(){return carService.getCars();}

    @PostMapping(value = "/add")
    public void addCar(@RequestBody Car car){carService.addCar(car);}

    @DeleteMapping(value = "delete/{id}")
    public void deleteCar(@PathVariable Long id){carService.deleteCar(id);}

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody CarDTO carDTO ){carService.updateCar(carDTO);}

}
