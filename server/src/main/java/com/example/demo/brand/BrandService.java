package com.example.demo.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


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

     void updateBrand(Brand brandDTO){
        Brand brand = brandRepository.findById(brandDTO.getId()).orElseThrow(()->new IllegalArgumentException("Brand not found"));


        brand.setName(brandDTO.getName());
        brand.setProducer(brandDTO.getProducer());
        brandRepository.save(brand);
     }

     void deleteBrand(long id){
        Brand brand = brandRepository.findById(id).get();
        brand.setNonactive();
        brandRepository.save(brand);
     }

    List<Brand> getActive(){
        return brandRepository.findAll().stream().filter( a -> a.getStatus()==1)
                .collect(Collectors.toList());
    }

    Brand getBrand(long id){
        return brandRepository.findById(id).get();
    }

}
