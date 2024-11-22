package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long>{
}
