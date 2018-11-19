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

    @PostMapping(value = "/add")
    public void addProducer(@RequestBody Producer producer){producerService.addProducer(producer);}
}
