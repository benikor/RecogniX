package com.github.kormosbenedek.RecogniX.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requestTreatment")
public class RequestTreatmentController {

    @GetMapping("/")
    public String getAll(){
        return "szeva";
    }
    @PostMapping("/")
    public String saveOne(){
        return "szia";
    }
}
