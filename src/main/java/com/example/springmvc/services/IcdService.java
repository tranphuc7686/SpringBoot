package com.example.springmvc.services;

import com.example.springmvc.Repo.IcdRepository;
import com.example.springmvc.models.Icd;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class IcdService {
    @Autowired
    private final IcdRepository IcdRespository;

    public void addIcd(Icd Icd) {
        IcdRespository.save(Icd);
    }
    public List<Icd> getAllIcds(){
        return IcdRespository.findAll();
    }
    public Optional<Icd> findById(int id){
        return Optional.ofNullable(IcdRespository.findOne(id));
    }
    public void updateIcd (Icd Icd){
        IcdRespository.save(Icd);
    }

    public void deleteIcd(int id){
        IcdRespository.delete(id);
    }

}
