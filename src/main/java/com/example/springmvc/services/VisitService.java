package com.example.springmvc.services;

import com.example.springmvc.Repo.PatientRespository;
import com.example.springmvc.Repo.VisitRepository;
import com.example.springmvc.models.Patient;
import com.example.springmvc.models.Visit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class VisitService {
    @Autowired
    private final VisitRepository mVisitRepository;

    public void addVisit(Visit Visit) {
        mVisitRepository.save(Visit);
    }
    public List<Visit> getAllVisits(){
        return mVisitRepository.findAll();
    }
    public List<Visit> getAllVisitsByPatientId(int id){
        return mVisitRepository.findAll().stream().filter(e -> e.getPatient().getId() == id).collect(Collectors.toList());
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
