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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addCar(@RequestBody Car car){carService.addCar(car);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteCar(@PathVariable long id){carService.deleteCar(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Car car ){carService.updateCar(car);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Car> getActive(){
        return carService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Car getCar(@PathVariable long id){
        return carService.getCar(id);
    }

}
