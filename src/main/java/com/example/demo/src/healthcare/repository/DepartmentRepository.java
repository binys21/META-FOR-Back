package com.example.demo.src.healthcare.repository;

import com.example.demo.src.healthcare.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
