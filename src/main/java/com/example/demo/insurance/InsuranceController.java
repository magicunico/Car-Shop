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

    @PostMapping(value = "/add")
    public void addInsurance(@RequestBody Insurance insurance){insuranceService.addInsurance(insurance);}

    @PostMapping(value = "/delete")
    public void deleteInsurance(@RequestBody Insurance insurance){insuranceService.deleteInsurance(insurance);}
}
