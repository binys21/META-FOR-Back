package com.example.demo.src.healthcare.controller;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.healthcare.dto.DiseaseDetailsDto;
import com.example.demo.src.healthcare.service.HealthcareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @GetMapping("/disease/details")
    @Operation(summary = "질병 상세 정보 조회", description = "질병 이름을 통해 상세 정보 조회", responses = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "404", description = "검색 결과 없음")
    })
    public BaseResponse<DiseaseDetailsDto> getDiseaseDetails(@RequestParam String diseaseName) {
        DiseaseDetailsDto result = healthcareService.getDiseaseDetails(diseaseName);
        return new BaseResponse<>(result);
    }




}
