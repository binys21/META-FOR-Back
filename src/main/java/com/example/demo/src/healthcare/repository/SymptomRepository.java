package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<SymptomEntity, Long> {
}
