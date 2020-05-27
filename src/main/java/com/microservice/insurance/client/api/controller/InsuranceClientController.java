package com.microservice.insurance.client.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class InsuranceClientController {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${insurance.provider.url}")
    private String url;

    @GetMapping("/get-plan")
    public List<String> getPlans(){
        List<String> plans = restTemplate.getForObject(url, List.class);
        return plans;
    }
}
