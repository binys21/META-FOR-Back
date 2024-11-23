package com.example.demo.src.ai.controller;

import com.example.demo.src.ai.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gemini")
public class GeminiController {

    private final GeminiService geminiService;

    @CrossOrigin
    @GetMapping("/chat")
    public String gemini() {
        try {
            return geminiService.getContents("안녕! 너는 누구야?");
        } catch (HttpClientErrorException e) {
            return "에러";
        }
    }
}