package com.example.demo.insurance;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Insurance> getAll(){return insuranceService.getInsurances();}

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addInsurance(@RequestBody Insurance insurance){insuranceService.addInsurance(insurance);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable long id){insuranceService.deleteInsurance(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Insurance insuranceDTO ){insuranceService.updateInsurance(insuranceDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Insurance> getActive(){
        return insuranceService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Insurance getInsurance(@PathVariable long id){
        return insuranceService.getInsurance(id);
    }
}
