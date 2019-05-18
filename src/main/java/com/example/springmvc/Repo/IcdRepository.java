package com.example.springmvc.Repo;

import com.example.springmvc.models.Icd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcdRepository extends JpaRepository<Icd, Integer> {
}
