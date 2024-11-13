package fr.hb.jg.business_case.controller_api;

import fr.hb.jg.business_case.custom_response.JwtResponse;
import fr.hb.jg.business_case.dto.UserLoginDTO;
import fr.hb.jg.business_case.dto.UserRegisterDTO;
import fr.hb.jg.business_case.entity.User;
import fr.hb.jg.business_case.security.JwtAuthenticatorService;
import fr.hb.jg.business_case.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class SecurityRestRestController {

    private final UserService userService;

    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/api/auth/register")
    public User register(@Valid @RequestBody UserRegisterDTO user) {
        return userService.create(user);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDTO user) {
        return jwtAuthenticatorService.authenticate(user);
    }

}