package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name ="drugdetail")
public class DrugDetail {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int drugquantity;
    @Column
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    Date datewithouttime=new SimpleDateFormat("dd-MM-yyyy").parse(dateFormat.format(date));


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Drug drug;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Prescription prescription;

    public DrugDetail() throws ParseException {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrugquantity() {
        return drugquantity;
    }

    public void setDrugquantity(int drugquantity) {
        this.drugquantity = drugquantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date getDatewithouttime() {
        return datewithouttime;
    }

    public void setDatewithouttime(Date datewithouttime) {
        this.datewithouttime = datewithouttime;
    }
}
