package com.example.springmvc.controllers;

import com.example.springmvc.models.Visit;
import com.example.springmvc.services.VisitService;
import com.example.springmvc.viewmodel.HisVisitDto;
import com.example.springmvc.viewmodel.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService VisitService;
    @CrossOrigin
    @RequestMapping(path = "visit", method = RequestMethod.POST)
    public void saveVisit(@RequestBody VisitDto visitDto){
        VisitService.addVisit(visitDto);
    }

    @CrossOrigin
    @RequestMapping(path = "visit/{id}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable int id){
         if(VisitService.findById(id).isPresent()){
             return VisitService.findById(id).get();
         }

        return new Visit();
    }
    @CrossOrigin
    @RequestMapping(path = "find/visit/{id}", method = RequestMethod.GET)
    public List<HisVisitDto> getVisitByIdPatient(@PathVariable int id){
        return VisitService.getAllVisitsByPatientId(id);
    }
    @CrossOrigin
    @RequestMapping(path = "visits", method = RequestMethod.GET)
    public List<Visit> getAllVisits(){
        return VisitService.getAllVisits();
    }
    @CrossOrigin
    @RequestMapping(path = "visit/{id}", method = RequestMethod.DELETE)
    public void deleteVisitById(@PathVariable int id){
        VisitService.deleteVisit(id);
    }

    @CrossOrigin
    @RequestMapping(path = "visit", method = RequestMethod.PUT)
    public void updateVisit(@RequestBody Visit Visit){
        VisitService.updateVisit(Visit);
    }




}
