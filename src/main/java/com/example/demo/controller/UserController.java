package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/V1/")


public class UserController {
    @GetMapping("/getUser")


    public String getUser() {
        return "Hello Kithru1";
    }
}


