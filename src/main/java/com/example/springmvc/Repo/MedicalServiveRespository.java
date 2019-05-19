package com.example.springmvc.Repo;

import com.example.springmvc.models.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalServiveRespository extends JpaRepository<MedicalService, Integer> {
}

