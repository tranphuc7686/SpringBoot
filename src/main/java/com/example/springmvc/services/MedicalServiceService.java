package com.example.springmvc.services;

import com.example.springmvc.Repo.LabTestRepository;
import com.example.springmvc.Repo.MedicalServiveRespository;
import com.example.springmvc.Repo.PatientRespository;
import com.example.springmvc.Repo.VisitRepository;
import com.example.springmvc.models.LabTest;
import com.example.springmvc.models.MedicalService;
import com.example.springmvc.models.Visit;
import com.example.springmvc.viewmodel.MedicalServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class MedicalServiceService {
    @Autowired
    private final MedicalServiveRespository medicalServiveRespository;
    private final LabTestRepository labTestRepository;
    private final VisitRepository visitRepository;
    private final PatientRespository patientRespository;
    public void addMedicalServive(MedicalServiceDto medicalServiceDto) {
        LabTest mLabTest = new LabTest();
        mLabTest.setDate(medicalServiceDto.getDate());
        mLabTest.setTime(medicalServiceDto.getTime());

        Visit visit = new Visit();
        visit.setPatient(patientRespository.findOne(Integer.parseInt(medicalServiceDto.patient_id)));
        Calendar currenttime = Calendar.getInstance();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        visit.setDate(date);
        visit.setTime(new java.sql.Time((currenttime.getTime()).getTime()));
        visit.setLabTest(mLabTest);

        List<LabTest> mLabTests = new ArrayList<>();
        mLabTests.add(mLabTest);
        MedicalService medicalService = new MedicalService();
        medicalService.setLabTestes(mLabTests);


        labTestRepository.save(mLabTest);
        visitRepository.save(visit);
        medicalServiveRespository.save(medicalService);
    }
    public List<MedicalService> getAllMedicalServives(){
        return medicalServiveRespository.findAll();
    }
    public Optional<MedicalService> findById(int id){
        return Optional.ofNullable(medicalServiveRespository.findOne(id));
    }
    public void updateMedicalServive (MedicalService MedicalServive){
        medicalServiveRespository.save(MedicalServive);
    }

    public void deleteMedicalServive(int id){
        medicalServiveRespository.delete(id);
    }
}
