package com.example.demo.src.user.controller;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.dto.LoginDto;
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
            System.out.print("1");
            userService.signUp(signUpDto);
            System.out.print("4");

            return new BaseResponse<>("회원 가입 성공!");

        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
    @PostMapping("/login")
    @Operation(summary = "로그인 api", description = "LoginDto에 담긴 정보를 토대로 로그인", responses = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "401", description = "아이디나 비밀번호가 올바르지 않음")
    })
    public BaseResponse<String> login(@RequestBody @Valid LoginDto loginDto) {
        try {
            String result = userService.login(loginDto);
            return new BaseResponse<>(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }


}
