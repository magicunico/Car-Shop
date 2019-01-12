package com.example.demo.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {
    private InsuranceRepository insuranceRepository;

    @Autowired
     InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

     List<Insurance> getInsurances(){return insuranceRepository.findAll();}

     void addInsurance(Insurance insurance){insuranceRepository.save(insurance);}

     void deleteInsurance(Long id){
        Insurance insurance = insuranceRepository.findById(id).get();
        insurance.setNonactive();
        insuranceRepository.save(insurance);
    }

     void updateInsurance(InsuranceDTO insuranceDTO){
        Insurance insurance = insuranceRepository.findById(insuranceDTO.getId()).orElseThrow(()-> new IllegalArgumentException("Insurance not found"));

        insurance.setName(insuranceDTO.getName());
        insurance.setStarting(insuranceDTO.getStarting());
        insurance.setEnding(insuranceDTO.getEnding());
        insurance.setPrice(insuranceDTO.getPrice());
        insuranceRepository.save(insurance);
     }

    List<Insurance> getActive(){
        return insuranceRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }

    Insurance getInsurance(Long id){
        return insuranceRepository.findById(id).get();
    }

}
