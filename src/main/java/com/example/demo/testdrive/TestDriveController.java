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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addTestDrive(@RequestBody TestDrive testDrive){testDriveService.addTestDrive(testDrive);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteInsurance(@PathVariable Long id){testDriveService.deleteTestDrive(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody TestDriveDTO testDriveDTO){testDriveService.updateTestDrive(testDriveDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<TestDrive> getActive(){
        return testDriveService.getActive();
    }
}
