package com.example.springmvc.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisitDto {
    public String date;
    public String diagnosis_id;
    public String patient_id;
    public String problems;
    public String time;
}
