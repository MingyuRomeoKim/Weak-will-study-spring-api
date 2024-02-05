package com.weakwill.weakwillapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "hello world!!! 이제부터 Spring Boot를 사용해서 API를 만들어 보자고!! ";
    }
}
