package com.example.demo;

import com.example.demo.src.healthcare.entity.DiseaseEntity;
import com.example.demo.src.healthcare.entity.SymptomEntity;
import com.example.demo.src.healthcare.repository.DiseaseRepository;
import com.example.demo.src.healthcare.repository.SymptomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DiseaseRepository diseaseRepository;
    private final SymptomRepository symptomRepository;

    public DataInitializer(DiseaseRepository diseaseRepository, SymptomRepository symptomRepository) {
        this.diseaseRepository = diseaseRepository;
        this.symptomRepository = symptomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SymptomEntity cough = new SymptomEntity();
        cough.setSymptomName("기침");
        cough.setSymptomDetail("기침이 지속적으로 나오는 증상입니다.");
        symptomRepository.save(cough);

        DiseaseEntity cold = new DiseaseEntity();
        cold.setDiseaseName("감기");
        cold.setCaustion("찬 곳에 가지 마세요.");
        cold.setImprovement("충분히 쉬세요.");
        cold.setSymptomEntity(cough);
        diseaseRepository.save(cold);

        System.out.println("테스트 데이터가 초기화되었습니다.");
    }
}
