package com.example.springmvc.Repo;

import com.example.springmvc.models.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabTestRepository extends JpaRepository<LabTest, Integer> {
}
