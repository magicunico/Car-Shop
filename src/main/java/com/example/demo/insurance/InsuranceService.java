package com.example.demo.insurance;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    private InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> getInsurances(){return insuranceRepository.findAll();}

    public void addInsurance(Insurance insurance){insuranceRepository.save(insurance);}

    public void deleteInsurance(Insurance insurance){insuranceRepository.delete(insurance);}
}
