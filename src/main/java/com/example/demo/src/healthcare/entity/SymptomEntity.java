package com.example.demo.src.healthcare.entity;

import com.example.demo.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@Table(name="symptom")
@NoArgsConstructor
@DynamicInsert

public class SymptomEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="symptomId")
    private Long symptomId;

    @Column(nullable = false,length = 50)
    private String symptomName;

    @Column(nullable = false)
    private String symptomDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private DepartmentEntity departmentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diseaseId")
    private DiseaseEntity diseaseEntity;
}
