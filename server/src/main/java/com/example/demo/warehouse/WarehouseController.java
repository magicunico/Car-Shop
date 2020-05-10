package com.example.demo.warehouse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Warehouse> getAll(){
        return warehouseService.getWarehousess();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.addWarehouse(warehouse);
    }

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteWarehouse(@PathVariable long id){warehouseService.deleteWarehouse(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Warehouse warehouseDTO){warehouseService.updateWarehouse(warehouseDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Warehouse> getActive(){ return warehouseService.getActive(); }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Warehouse getWarehouse(@PathVariable long id){
        return warehouseService.getWarehouse(id);
    }
}
