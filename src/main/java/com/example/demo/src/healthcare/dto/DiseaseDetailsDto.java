package com.example.demo.src.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DiseaseDetailsDto {
    private String diseaseName;
    private String caution;
    private String improvement;
    private String symptom;
}
