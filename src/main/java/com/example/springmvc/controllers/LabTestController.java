package com.example.springmvc.controllers;

import com.example.springmvc.models.LabTest;
import com.example.springmvc.models.LabTest;
import com.example.springmvc.services.LabTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = {"/"}
)
@RequiredArgsConstructor
public class LabTestController {
    private final LabTestService LabTestService;
    @CrossOrigin
    @RequestMapping(path = "LabTest", method = RequestMethod.POST)
    public void saveLabTest(@RequestBody LabTest LabTest){
        LabTestService.addLabTest(LabTest);
    }
    @CrossOrigin
    @RequestMapping(path = "LabTest/{id}", method = RequestMethod.GET)
    public Optional<LabTest> getLabTestById(@PathVariable int id){
        return LabTestService.findById(id);
    }
    @CrossOrigin
    @RequestMapping(path = "LabTest/{id}", method = RequestMethod.DELETE)
    public void deleteLabTestById(@PathVariable int id){
        LabTestService.deleteLabTest(id);
    }
    @CrossOrigin
    @RequestMapping(path = "LabTest", method = RequestMethod.PUT)
    public void updateLabTest(@RequestBody LabTest LabTest){
        LabTestService.updateLabTest(LabTest);
    }

}
