package com.example.demo.producer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Producer> getAll(){return producerService.getProducers();}

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addProducer(@RequestBody Producer producer){producerService.addProducer(producer);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable long id){producerService.deleteProducer(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Producer producerDTO ){producerService.updateProducer(producerDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Producer> getActive(){
        return producerService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Producer getProducer(@PathVariable long id){
        return producerService.getProducer(id);
    }
}
