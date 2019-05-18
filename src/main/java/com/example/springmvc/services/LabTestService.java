package com.example.springmvc.services;

import com.example.springmvc.Repo.LabTestRepository;
import com.example.springmvc.models.LabTest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LabTestService {
    @Autowired
    private final LabTestRepository mLabTestRepository;

    public void addLabTest(LabTest LabTest) {
        mLabTestRepository.save(LabTest);
    }
    public List<LabTest> getAllLabTests(){
        return mLabTestRepository.findAll();
    }
    public Optional<LabTest> findById(int id){
        return Optional.ofNullable(mLabTestRepository.findOne(id));
    }
    public void updateLabTest (LabTest LabTest){
        mLabTestRepository.save(LabTest);
    }

    public void deleteLabTest(int id){
        mLabTestRepository.delete(id);
    }

}
