package com.example.springmvc.Repo;

import com.example.springmvc.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRespository extends JpaRepository<Patient, Integer> {
}
