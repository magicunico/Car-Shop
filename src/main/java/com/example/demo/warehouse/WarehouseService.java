package com.example.demo.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    @Autowired
     WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

     List<Warehouse> getWarehousess(){
        return warehouseRepository.findAll();
    }

     void addWarehouse(Warehouse warehouse){
        warehouseRepository.save(warehouse);
    }

     void deleteWarehouse(Long id){
        Warehouse warehouse = warehouseRepository.findById(id).get();
        warehouse.setNonactive();
        warehouseRepository.save(warehouse);
    }

    void updateWarehouse(WarehouseDTO warehouseDTO){
        Warehouse warehouse = warehouseRepository.findById(warehouseDTO.getId()).orElseThrow(()-> new IllegalArgumentException("warehouse not found"));

        warehouse.setName(warehouseDTO.getName());

        warehouseRepository.save(warehouse);
    }

    List<Warehouse> getActive(){
        return warehouseRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }

    Warehouse getWarehouse(Long id){
        return warehouseRepository.findById(id).get();
    }


}
