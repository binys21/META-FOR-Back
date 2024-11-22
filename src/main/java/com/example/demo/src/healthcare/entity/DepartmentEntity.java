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
@Table(name="department")
@NoArgsConstructor
@DynamicInsert
public class DepartmentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="deptId")
    private Long deptId;

    @Column(nullable = false,length = 50)
    private String deptName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalId")
    private HospitalEntity hospitalEntity;

}
