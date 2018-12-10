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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addRepair(@RequestBody Repair repair){repairService.addRepair(repair);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable Long id){repairService.deleteRepair(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody RepairDTO repairDTO){repairService.updateRepair(repairDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Repair> getActive(){
        return repairService.getActive();
    }
}
