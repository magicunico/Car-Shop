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

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        brandService.deleteBrand(id);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody BrandDTO brandDTO ){brandService.updateBrand(brandDTO);}

}
