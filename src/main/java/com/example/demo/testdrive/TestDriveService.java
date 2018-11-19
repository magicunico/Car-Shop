package com.example.demo.testdrive;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    private TestDriveRepository testDriveRepository;

    public TestDriveService(TestDriveRepository testDriveRepository) {
        this.testDriveRepository = testDriveRepository;
    }

    public List<Testdrive> getTestDrives(){return testDriveRepository.findAll();}

    public void addTestDrive(Testdrive testDrive){testDriveRepository.save(testDrive);}
}
