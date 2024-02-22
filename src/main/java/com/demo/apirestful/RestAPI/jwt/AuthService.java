package com.demo.apirestful.RestAPI.jwt;

import com.demo.apirestful.RestAPI.Registro.RegisterRequest;
import com.demo.apirestful.RestAPI.access.LoginRequest;
import com.demo.apirestful.RestAPI.access.User;
import com.demo.apirestful.RestAPI.access.Role;
import com.demo.apirestful.RestAPI.repository.ServiceAuth;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demo.apirestful.RestAPI.repository.userRepository;
import org.springframework.web.server.ResponseStatusException;

@Builder
@RequiredArgsConstructor
@Service
public class AuthService implements ServiceAuth {

    private final userRepository userRepository;
    private final JWTService JWTService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public Authresponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = JWTService.getToken(user);
        return Authresponse.builder().token(jwtToken).build();
    }

    @Override
    public Authresponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()) != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Correo ya registrado");

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

                userRepository.save(user);
                var jwtToken = JWTService.getToken(user);
                return Authresponse.builder()
                        .token(jwtToken)
                        .build();
    }

}
