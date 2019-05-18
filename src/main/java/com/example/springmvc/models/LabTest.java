package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lab_test")
public class LabTest {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Date date;
    @Column
    private Time time;

    @OneToMany(mappedBy = "labTest",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MedicalService> medicalServices;

    @OneToMany(mappedBy = "labTest",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Visit> visits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MedicalService> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(List<MedicalService> medicalServices) {
        this.medicalServices = medicalServices;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
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
}
