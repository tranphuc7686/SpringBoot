package com.example.springmvc.controllers;

import com.example.springmvc.models.Icd;
import com.example.springmvc.models.Icd;
import com.example.springmvc.services.IcdService;
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
public class IcdController {
    private final IcdService IcdService;
    @CrossOrigin
    @RequestMapping(path = "Icd", method = RequestMethod.POST)
    public void saveIcd(@RequestBody Icd Icd){
        IcdService.addIcd(Icd);
    }
    @CrossOrigin
    @RequestMapping(path = "Icd/{id}", method = RequestMethod.GET)
    public Optional<Icd> getIcdById(@PathVariable int id){
        return IcdService.findById(id);
    }
    @CrossOrigin
    @RequestMapping(path = "icd", method = RequestMethod.GET)
    public List<Icd> getAllIcd(){
        return IcdService.getAllIcds();
    }
    @CrossOrigin
    @RequestMapping(path = "Icd/{id}", method = RequestMethod.DELETE)
    public void deleteIcdById(@PathVariable int id){
        IcdService.deleteIcd(id);
    }
    @CrossOrigin
    @RequestMapping(path = "Icd", method = RequestMethod.PUT)
    public void updateIcd(@RequestBody Icd Icd){
        IcdService.updateIcd(Icd);
    }
}
