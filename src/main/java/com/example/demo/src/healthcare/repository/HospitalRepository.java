package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
}
