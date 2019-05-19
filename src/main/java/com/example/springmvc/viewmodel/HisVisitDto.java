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
public class HisVisitDto {

    private Date date;

    private Time time;

    private String problems;

    private String icdName;
}
