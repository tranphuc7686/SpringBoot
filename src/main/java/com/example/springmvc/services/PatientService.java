package com.example.springmvc.services;

import com.example.springmvc.Repo.PatientRespository;
import com.example.springmvc.models.Patient;
import lombok.RequiredArgsConstructor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private final PatientRespository patientRespository;

    public void addPatient(Patient patient) {
        patientRespository.save(patient);
    }
    public List<Patient> getAllPatients(){
        return patientRespository.findAll();
    }
    public Optional<Patient> findById(int id){
        return Optional.ofNullable(patientRespository.findOne(id));
    }
    public void updatePatient (Patient patient){
        patientRespository.save(patient);
    }

    public void deletePatient(int id){
       patientRespository.delete(id);
    }

}
