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
    public List<TestDrive> getAll(){return testDriveService.getTestDrives();}

    @PostMapping(value = "/add")
    public void addTestDrive(@RequestBody TestDrive testDrive){testDriveService.addTestDrive(testDrive);}

    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable Long id){testDriveService.deleteTestDrive(id);}

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody TestDriveDTO testDriveDTO){testDriveService.updateTestDrive(testDriveDTO);}

}
