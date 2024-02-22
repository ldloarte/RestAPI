package com.demo.apirestful.RestAPI.access;

import com.demo.apirestful.RestAPI.Registro.RegisterRequest;
import com.demo.apirestful.RestAPI.jwt.AuthService;
import com.demo.apirestful.RestAPI.jwt.Authresponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.apirestful.RestAPI.Service.userService;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class userController {

    private final AuthService authService;
    private userService userService;

    @PostMapping(value = "login")
    public ResponseEntity<Authresponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<Authresponse> register(@Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

}
