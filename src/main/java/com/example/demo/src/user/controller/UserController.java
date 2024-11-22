package com.example.demo.src.user.controller;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.dto.SignUpDto;
import com.example.demo.src.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    @Operation(summary = "회원가입 api", description = "SignUpDto에 담긴 정보를 토대로 회원가입", responses = {
        @ApiResponse(responseCode = "200", description = "성공"),
        @ApiResponse(responseCode = "400", description = "파라미터오류")
    })
    public BaseResponse<String> signUp(@RequestBody @Valid SignUpDto signUpDto){
        try{
            userService.signUp(signUpDto);

            return new BaseResponse<>("회원 가입 성공!");

        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
