package com.example.springmvc.controllers;

import com.example.springmvc.models.Prescription;
import com.example.springmvc.services.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    @CrossOrigin
    @RequestMapping(path = "prescription", method = RequestMethod.POST)
    public void savePrescription(@RequestBody Prescription prescription){
        prescriptionService.addPrescription(prescription);
    }
    @CrossOrigin
    @RequestMapping(path = "prescription/{id}", method = RequestMethod.GET)
    public Optional<Prescription> getPrescriptionById(@PathVariable int id){
        return prescriptionService.findById(id);
    }
    @CrossOrigin
    @RequestMapping(path = "prescription/{id}", method = RequestMethod.DELETE)
    public void deletePrescriptionById(@PathVariable int id){
        prescriptionService.deletePrescription(id);
    }
    @CrossOrigin
    @RequestMapping(path = "prescription", method = RequestMethod.PUT)
    public void updatePrescription(@RequestBody Prescription prescription){
        prescriptionService.updatePrescription(prescription);
    }


}