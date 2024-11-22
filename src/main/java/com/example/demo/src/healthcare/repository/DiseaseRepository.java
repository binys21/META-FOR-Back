package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long>{

    // 질병 이름으로 검색
    Optional<DiseaseEntity> findByDiseaseName(String diseaseName);
    // 증상 ID로 모든 질병 검색
    List<DiseaseEntity> findAllBySymptomEntity_SymptomId(Long symptomId);


}
