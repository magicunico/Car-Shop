package com.example.demo.brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getBrands(){return brandRepository.findAll();}

    public void addBrand(Brand brand){brandRepository.save(brand);}
}
