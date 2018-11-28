package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    private ProducerRepository producerRepository;

    @Autowired
     ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

     List<Producer> getProducers(){return producerRepository.findAll();}

     void addProducer(Producer producer){producerRepository.save(producer);}

    void deleteProducer(Long id){
        Producer producer = producerRepository.findById(id).get();
        producer.setNonactive();
        producerRepository.save(producer);
    }

    void updateProducer(ProducerDTO producerDTO){
        Producer producer = producerRepository.findById(producerDTO.getId()).orElseThrow(()->new IllegalArgumentException("Producer not found"));
            producer.setName(producerDTO.getName());
          producerRepository.save(producer);
    }
}
