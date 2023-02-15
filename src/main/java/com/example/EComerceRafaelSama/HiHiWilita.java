package com.example.EComerceRafaelSama;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HiHiWilita {
    @GetMapping("/hihi")
    public String Hi(){
        return "Hola, Wilita <3";
    }
}
