package com.example.demo.src.healthcare.dto;
import com.example.demo.src.healthcare.entity.DiseaseEntity;

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
    private String caustion;
    private String improvement;
    private String symptom;

    public DiseaseDetailsDto(DiseaseEntity diseaseEntity) {
        this.diseaseName = diseaseEntity.getDiseaseName();
        this.caustion = diseaseEntity.getCaustion();
        this.improvement = diseaseEntity.getImprovement();
    }
}
