package com.example.demo.warehouse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getWarehousess(){
        return warehouseRepository.findAll();
    }

    public void addWarehouse(Warehouse warehouse){
        warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Warehouse warehouse){warehouseRepository.delete(warehouse);}
}
