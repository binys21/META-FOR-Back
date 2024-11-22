package com.example.demo.src.healthcare.service;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.healthcare.dto.DiseaseDetailsDto;
import com.example.demo.src.healthcare.entity.DiseaseEntity;
import com.example.demo.src.healthcare.entity.SymptomEntity;
import com.example.demo.src.healthcare.repository.DiseaseRepository;
import com.example.demo.src.healthcare.repository.SymptomRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HealthcareService {
    private final DiseaseRepository diseaseRepository;
    private final SymptomRepository symptomRepository;

    public Object searchByKeyword(String keyword) throws BaseException {
        //질병 이름으로 검색
        var disease=diseaseRepository.findByDiseaseName(keyword);
        if(disease.isPresent()){
            return new DiseaseDetailsDto(disease.get());
        }
        //증상 이름으로 검색
        var symptom=symptomRepository.findBySymptomName(keyword);
        if(symptom.isPresent()){
            //해당 증상과 관련된 모든 질병 반환
            List<DiseaseDetailsDto> diseases=diseaseRepository.findAllBySymptomEntity_SymptomId(symptom.get().getSymptomId())
                    .stream()
                    .map(DiseaseDetailsDto::new)
                    .collect(Collectors.toList());
            return diseases;
        }
        throw new BaseException(BaseResponseStatus.SEARCH_NOT_FOUND);
    }
    public DiseaseDetailsDto getDiseaseDetails(String diseaseName) throws BaseException {
        DiseaseEntity diseaseEntity = diseaseRepository.findByDiseaseName(diseaseName)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.SEARCH_NOT_FOUND));

        return new DiseaseDetailsDto(diseaseEntity);
    }


}
