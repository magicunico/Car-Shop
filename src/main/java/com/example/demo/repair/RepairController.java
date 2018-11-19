package com.example.demo.repair;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {
    private RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Repair> getAll(){ return repairService.getRepairs();}

    @PostMapping(value = "/add")
    public void addRepair(@RequestBody Repair repair){repairService.addRepair(repair);}
}
