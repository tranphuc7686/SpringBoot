package com.example.springmvc.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Type(type = "org.hibernate.type.TextType")
    private String name;


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "drug", cascade = CascadeType.ALL)
    @JsonIgnore
    private DrugDetail drugdetail;

    public Drug() {
    }

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


    public DrugDetail getDrugdetail() {
        return drugdetail;
    }

    public void setDrugdetail(DrugDetail drugdetail) {
        this.drugdetail = drugdetail;
    }
}
