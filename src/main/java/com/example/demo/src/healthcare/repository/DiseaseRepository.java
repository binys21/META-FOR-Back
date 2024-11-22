package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long>{
    DiseaseEntity findByDiseaseName(String diseaseName);
}
