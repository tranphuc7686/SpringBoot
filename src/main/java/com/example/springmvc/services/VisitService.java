package com.example.springmvc.services;

import com.example.springmvc.Repo.IcdRepository;
import com.example.springmvc.Repo.PatientRespository;
import com.example.springmvc.Repo.VisitRepository;
import com.example.springmvc.models.Icd;
import com.example.springmvc.models.Patient;
import com.example.springmvc.models.Visit;
import com.example.springmvc.viewmodel.HisVisitDto;
import com.example.springmvc.viewmodel.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class VisitService {
    @Autowired
    private final VisitRepository mVisitRepository;
    private final IcdRepository mIcdRepository;
    private final PatientRespository mPatientRespository;


    public void addVisit(VisitDto visitDto) {
        Icd mIcd =  mIcdRepository.getOne(Integer.parseInt(visitDto.diagnosis_id));
        Patient mPatient =  mPatientRespository.getOne(Integer.parseInt(visitDto.patient_id));
        Visit visit = new Visit();
        visit.setDiagnosis(mIcd);
        visit.setPatient(mPatient);

        //date
        Calendar currenttime = Calendar.getInstance();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        visit.setDate(date);
        visit.setTime(new java.sql.Time((currenttime.getTime()).getTime()));
        visit.setProblems(visitDto.problems);
        mVisitRepository.save(visit);
    }
    public List<Visit> getAllVisits(){
        return mVisitRepository.findAll();
    }
    public List<HisVisitDto> getAllVisitsByPatientId(int id){
        return mVisitRepository.findAll()
                .stream()
                .filter(e -> e.getPatient().getId() == id).collect(Collectors.toList())
                .stream().map(e -> {
            return new HisVisitDto(e.getDate(),e.getTime(),e.getProblems(),e.getDiagnosis().getDiseaseName());
        }).collect(Collectors.toList());
    }
    public Optional<Visit> findById(int id){
        return Optional.ofNullable(mVisitRepository.findOne(id));
    }
    public void updateVisit (Visit Visit){
        mVisitRepository.save(Visit);
    }

    public void deleteVisit(int id){
        mVisitRepository.delete(id);
    }


}
