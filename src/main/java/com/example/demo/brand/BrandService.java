package com.example.demo.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    @Autowired
    BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

     List<Brand> getBrands(){return brandRepository.findAll();}

     void addBrand(Brand brand){brandRepository.save(brand);}

}
