package com.example.springmvc.controllers;

import com.example.springmvc.models.Icd;
import com.example.springmvc.models.MedicalService;
import com.example.springmvc.services.IcdService;
import com.example.springmvc.services.MedicalServiceService;
import com.example.springmvc.viewmodel.MedicalServiceDto;
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
public class MedicalServiceController {

    private final MedicalServiceService medicalServiceService;

    @CrossOrigin
    @RequestMapping(path = "medicalServive", method = RequestMethod.POST)
    public void saveMedicalServive(@RequestBody MedicalServiceDto medicalServiceDto){
        medicalServiceService.addMedicalServive(medicalServiceDto);
    }
    @CrossOrigin
    @RequestMapping(path = "medicalServive/{id}", method = RequestMethod.GET)
    public Optional<MedicalService> getMedicalServiveById(@PathVariable int id){
        return medicalServiceService.findById(id);
    }

    @CrossOrigin
    @RequestMapping(path = "medicalServives", method = RequestMethod.GET)
    public List<MedicalService> getAllMedicalSerivce() {
        return medicalServiceService.getAllMedicalServives();
    }


     @CrossOrigin
    @RequestMapping(path = "medicalServive/{id}", method = RequestMethod.DELETE)
    public void deleteMedicalServiveById(@PathVariable int id){
        medicalServiceService.deleteMedicalServive(id);
    }
    @CrossOrigin
    @RequestMapping(path = "medicalServive", method = RequestMethod.PUT)
    public void updateMedicalServive(@RequestBody MedicalService MedicalServive){
        medicalServiceService.updateMedicalServive(MedicalServive);
    }

}
