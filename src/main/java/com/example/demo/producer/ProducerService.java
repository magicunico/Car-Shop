package com.example.demo.producer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    private ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public List<Producer> getProducers(){return producerRepository.findAll();}

    public void addProducer(Producer producer){producerRepository.save(producer);}
}
