package com.example.demo.src.healthcare.controller;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.healthcare.service.HealthcareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class healthcareController {

    private final HealthcareService healthcareService;
    @GetMapping("/search")
    public BaseResponse<Object> search(@RequestParam String keyword) {
        try {
            Object result = healthcareService.searchByKeyword(keyword);
            return new BaseResponse<>(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getMessage());
        }
    }


}
