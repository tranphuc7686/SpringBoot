package com.example.springmvc.Repo;

import com.example.springmvc.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRespository extends JpaRepository<Prescription, Integer> {
}
