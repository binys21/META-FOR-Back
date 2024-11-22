package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SymptomRepository extends JpaRepository<SymptomEntity, Long> {
    // 증상 이름으로 검색
    Optional<SymptomEntity> findBySymptomName(String symptomName);
}
