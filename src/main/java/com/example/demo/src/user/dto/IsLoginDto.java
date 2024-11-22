package com.example.demo.src.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class IsLoginDto {
    private String username;
    private Boolean isLogin;

    public IsLoginDto(String username, Boolean isLogin){
        this.username = username;
        this.isLogin = isLogin;
    }
}
