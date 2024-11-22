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
@Table(name="hospital")
@NoArgsConstructor
@DynamicInsert

public class HospitalEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hospitalId")
    private Long hospitalId;

    @Column(nullable = false,length = 50)
    private String hospitalName;

    @Column(nullable = false)
    private double hospitalRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private DepartmentEntity departmentEntity;
}
