package com.example.gestion_tienda.auth;

import com.example.gestion_tienda.config.JwtService;
import com.example.gestion_tienda.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")

public class AuthControlle {
    private final JwtService jwtService;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        if (request.username().equals("admin") &&
                request.password().equals("12345")) {

            String token = jwtService.generateToken(request.username());
            return Map.of("token", token);
        }

        throw new BusinessRuleException("Credenciales inválidas");
    }
}
