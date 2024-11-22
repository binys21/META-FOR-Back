package com.example.demo.src.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Schema(description = "회원가입 요청 DTO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    @Schema(description = "아이디", nullable = true, example = "cos123@naver.com")
    @NotBlank(message = "아이디를 입력해주세요")
    @Size
    private String username;

    @Schema(description = "비밀번호", nullable = true, example = "sndlmdl!")
    @NotBlank(message = "비밀번호를 입력해주세요")
    //@Size(min = 4, max = 12, message = "비밀번호는 4자에서 12자 사이여야 합니다.")
    private String password;

}
