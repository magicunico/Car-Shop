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
    public void deleteInsurance(@PathVariable long id){repairService.deleteRepair(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Repair repairDTO){repairService.updateRepair(repairDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Repair> getActive(){
        return repairService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Repair getRepair(@PathVariable long id){
        return repairService.getRepair(id);
    }
}
