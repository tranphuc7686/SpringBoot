package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;

import java.sql.Time;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private Date date;

    @Column
    private Time time;

    @Column
    private String problems;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Icd diagnosis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private LabTest labTest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public Icd getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Icd diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }
}