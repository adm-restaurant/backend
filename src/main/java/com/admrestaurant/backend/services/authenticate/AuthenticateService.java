package com.admrestaurant.backend.services.authenticate;

import com.admrestaurant.backend.entities.Status;
import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.repository.UserRepository;
import com.admrestaurant.backend.security.JwtTokenService;
import com.admrestaurant.backend.services.authenticate.dto.JwtResponseDTO;
import com.admrestaurant.backend.services.authenticate.dto.UserAuthenticationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenService jwtService;
  private final AuthenticationManager authenticationManager;

  public JwtResponseDTO signup(UserAuthenticationDTO dto) throws Exception {

    if (userRepository.existsByName(dto.getName())) {
      throw new IllegalArgumentException("Email already exists");
    }

    String passwordHash = passwordEncoder.encode(dto.getPassword());

    User user = User.builder()
        .name(dto.getName())
        .password(passwordHash)
        .status(Status.ACTIVE)
        .build();
    userRepository.save(user);
    String jwt = jwtService.generateToken(user);
    return JwtResponseDTO.builder().token(jwt).build();
  }

  public JwtResponseDTO signin(UserAuthenticationDTO dto) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
    User user = userRepository.findByName(dto.getName())
        .orElseThrow(() -> new IllegalArgumentException("Invalid email"));
    String jwt = jwtService.generateToken(user);
    return JwtResponseDTO.builder().token(jwt).build();
  }
}
