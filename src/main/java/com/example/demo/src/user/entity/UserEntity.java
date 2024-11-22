package com.example.demo.src.user.entity;

import com.example.demo.config.BaseEntity;
import com.example.demo.src.user.dto.SignUpDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
@DynamicInsert
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    public UserEntity(SignUpDto signUpDto){
        this.username = signUpDto.getUsername();
        this.password = signUpDto.getPassword();
    }

}
