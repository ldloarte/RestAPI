package com.demo.apirestful.RestAPI.Interface;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class authController {

    @GetMapping("new")
    public String v1(){
        return "Hello from APIRestful";
    }

    @GetMapping("v2")
    public String v2(){
        return "Hello from APIRestful v2";
    }
}
