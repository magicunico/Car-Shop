package com.example.demo.brand;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Brand> getAll(){return brandService.getBrands();}

    @PostMapping(value = "/add")
    public void addBrand(@RequestBody Brand brand){brandService.addBrand(brand);}
}
