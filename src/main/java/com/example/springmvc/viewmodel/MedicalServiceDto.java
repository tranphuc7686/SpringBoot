package com.example.springmvc.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalServiceDto {

    private Date date;

    private Time time;

    public String medicalservice_id;

    public String patient_id;
}
