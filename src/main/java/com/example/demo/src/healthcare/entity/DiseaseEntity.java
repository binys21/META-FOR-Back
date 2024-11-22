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
@Table(name="disease")
@NoArgsConstructor
@DynamicInsert

public class DiseaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="diseaseId")
    private Long id;

    @Column(nullable = false,length = 50)
    private String diseaseName;

    @Column(nullable = false)
    private String caustion;

    @Column(nullable = false)
    private String improvement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptomId")
    private SymptomEntity symptomEntity;

}
