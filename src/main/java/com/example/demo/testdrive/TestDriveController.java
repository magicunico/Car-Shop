package com.example.demo.testdrive;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testdrive")
public class TestDriveController {
    private TestDriveService testDriveService;

    public TestDriveController(TestDriveService testDriveService) {
        this.testDriveService = testDriveService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Testdrive> getAll(){return testDriveService.getTestDrives();}

    @PostMapping(value = "/add")
    public void addTestDrive(@RequestBody Testdrive testDrive){testDriveService.addTestDrive(testDrive);}
}
