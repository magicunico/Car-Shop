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

    @PostMapping(value = "/add")
    public void addWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.addWarehouse(warehouse);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteWarehouse(@PathVariable Long id){warehouseService.deleteWarehouse(id);}

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody WarehouseDTO warehouseDTO){warehouseService.updateWarehouse(warehouseDTO);}

}