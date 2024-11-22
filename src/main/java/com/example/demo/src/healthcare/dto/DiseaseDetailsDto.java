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

    private String diseaseName;  // 질병 이름
    private String symptomName; // 관련 증상 이름
    private String caustion;    // 주의사항
    private String improvement;

    public DiseaseDetailsDto(DiseaseEntity diseaseEntity) {
        this.diseaseName = diseaseEntity.getDiseaseName();
        this.symptomName = diseaseEntity.getSymptomEntity().getSymptomName();
        this.caustion = diseaseEntity.getCaustion();
        this.improvement = diseaseEntity.getImprovement();
    }
}
