package com.admrestaurant.backend.resources.authenticate;

import com.admrestaurant.backend.services.authenticate.AuthenticateService;
import com.admrestaurant.backend.services.authenticate.dto.JwtResponseDTO;
import com.admrestaurant.backend.services.authenticate.dto.UserAuthenticationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticateResource {
    private final AuthenticateService authenticateService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponseDTO> signin(@RequestBody UserAuthenticationDTO userAuthenticationDTO) {
      return ResponseEntity.ok(authenticateService.signin(userAuthenticationDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseDTO> signup(@RequestBody UserAuthenticationDTO userAuthenticationDTO) throws Exception {
      return ResponseEntity.ok(authenticateService.signup(userAuthenticationDTO));
    }
}
