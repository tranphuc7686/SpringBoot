package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "medical_service")
public class MedicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "medicalServices",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LabTest> labTestes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<LabTest> getLabTestes() {
        return labTestes;
    }

    public void setLabTestes(List<LabTest> labTestes) {
        this.labTestes = labTestes;
    }
}
