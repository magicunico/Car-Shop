package com.example.demo.testdrive;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestDriveService {
    private TestDriveRepository testDriveRepository;

    @Autowired
     TestDriveService(TestDriveRepository testDriveRepository) {
        this.testDriveRepository = testDriveRepository;
    }

     List<TestDrive> getTestDrives(){return testDriveRepository.findAll();}

     void addTestDrive(TestDrive testDrive){testDriveRepository.save(testDrive);}

    void deleteTestDrive(Long id){
        TestDrive testDrive = testDriveRepository.findById(id).get();
        testDrive.setNonactive();
        testDriveRepository.save(testDrive);
    }

    void updateTestDrive(TestDriveDTO testDriveDTO){
        TestDrive testDrive=testDriveRepository.findById(testDriveDTO.getId()).orElseThrow(()-> new IllegalArgumentException("TestDrive not found"));

        testDrive.setDate(testDriveDTO.getDate());
        testDrive.setCustomer(testDriveDTO.getCustomer());
        testDrive.setEmployee(testDriveDTO.getEmployee());
        testDrive.setCar(testDriveDTO.getCar());
        testDriveRepository.save(testDrive);
    }

    List<TestDrive> getActive(){
        return testDriveRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }
}
