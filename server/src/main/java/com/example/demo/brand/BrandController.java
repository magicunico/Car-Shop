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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addBrand(@RequestBody Brand brand){brandService.addBrand(brand);}

    @CrossOrigin("*")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable long id){
        brandService.deleteBrand(id);
    }

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Brand brand ){brandService.updateBrand(brand);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Brand> getActive(){
        return brandService.getActive();
    }


    @CrossOrigin("*")
    @GetMapping("{id}")
    public Brand getBrand(@PathVariable long id){
        return brandService.getBrand(id);
    }
}
