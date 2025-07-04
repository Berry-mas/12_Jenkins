package com.smile.jenkins.controller;

import com.smile.jenkins.dto.CalculatorDto;
import com.smile.jenkins.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Jenkins test를 위해 내용 변경!!! Discord와 연동🐋 이 텍스트는 ArgoCD Test를 위해 남김";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDto> plusTwoNumbers(CalculatorDto calculatorDto) {
        log.info("핸들러 실행 여부 및 값 확인 : {}", calculatorDto);

        /* Service 계층으로 기능 요청 */
        int result = calculatorService.plusTwoNumbers(calculatorDto);

        calculatorDto.setSum(result);
        return ResponseEntity.ok(calculatorDto);
    }
}
