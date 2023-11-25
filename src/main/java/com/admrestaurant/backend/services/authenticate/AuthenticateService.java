package com.admrestaurant.backend.services.authenticate;

import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.repository.UserRepository;
import com.admrestaurant.backend.resources.user.mapper.UserMapper;
import com.admrestaurant.backend.security.JwtTokenService;
import com.admrestaurant.backend.services.authenticate.dto.JwtResponseDTO;
import com.admrestaurant.backend.services.authenticate.dto.UserAuthenticationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

  private final UserRepository userRepository;
  private final JwtTokenService jwtService;
  private final AuthenticationManager authenticationManager;

  public JwtResponseDTO login(UserAuthenticationDTO dto) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
    User user = userRepository.findByName(dto.getName()).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + dto.getId())
    );
    String jwt = jwtService.generateToken(user);
    return JwtResponseDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .role(user.getRole())
        .token(jwt)
        .build();
  }
}
