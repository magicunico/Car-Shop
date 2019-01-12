package com.example.demo.repair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairService {
    private RepairRepository repairRepository;

    @Autowired
    RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

     List<Repair> getRepairs(){return repairRepository.findAll();}

     void addRepair(Repair repair){repairRepository.save(repair);}

     void deleteRepair(Long id){
        Repair repair = repairRepository.findById(id).get();
        repair.setNonactive();
        repairRepository.save(repair);
     }

     void updateRepair(RepairDTO repairDTO){
        Repair repair = repairRepository.findById(repairDTO.getId()).orElseThrow(()->new IllegalArgumentException("Repair not found"));

        repair.setName(repairDTO.getName());
        repair.setPrice(repairDTO.getPrice());
        repair.setEmployee(repairDTO.getEmployee());
        repair.setCar(repairDTO.getCar());
        repairRepository.save(repair);
     }
    List<Repair> getActive(){
        return repairRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }

    Repair getRepair(Long id){
        return repairRepository.findById(id).get();
    }

}
