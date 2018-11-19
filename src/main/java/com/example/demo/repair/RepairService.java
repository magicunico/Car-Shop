package com.example.demo.repair;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    private RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public List<Repair> getRepairs(){return repairRepository.findAll();}

    public void addRepair(Repair repair){repairRepository.save(repair);}
}
