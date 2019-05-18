package com.example.springmvc.services;

import com.example.springmvc.Repo.PrescriptionRespository;
import com.example.springmvc.models.Prescription;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class PrescriptionService {

    @Autowired
    private final PrescriptionRespository prescriptionRespository;

    public void addPrescription(Prescription Prescription) {
        prescriptionRespository.save(Prescription);
    }
    public List<Prescription> getAllPrescriptions(){
        return prescriptionRespository.findAll();
    }
    public Optional<Prescription> findById(int id){
        return Optional.ofNullable(prescriptionRespository.findOne(id));
    }
    public void updatePrescription (Prescription Prescription){
        prescriptionRespository.save(Prescription);
    }

    public void deletePrescription(int id){
        prescriptionRespository.delete(id);
    }
}