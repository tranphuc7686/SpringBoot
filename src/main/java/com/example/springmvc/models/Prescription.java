package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int quantity;

    @Column
    private String dose;

    @Column
    private String howToUse;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "prescription",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DrugDetail> drugdetails;

    public Prescription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<DrugDetail> getDrugdetails() {
        return drugdetails;
    }

    public void setDrugdetails(List<DrugDetail> drugdetails) {
        this.drugdetails = drugdetails;
    }
}
