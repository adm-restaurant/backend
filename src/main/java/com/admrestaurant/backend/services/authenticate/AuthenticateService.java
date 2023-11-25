package com.admrestaurant.backend.services.authenticate;

import com.admrestaurant.backend.entities.Status;
import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.repository.UserRepository;
import com.admrestaurant.backend.security.JwtTokenService;
import com.admrestaurant.backend.services.authenticate.dto.JwtResponseDTO;
import com.admrestaurant.backend.services.authenticate.dto.UserAuthenticationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenService jwtService;
  private final AuthenticationManager authenticationManager;

  public JwtResponseDTO register(UserAuthenticationDTO dto) {

    if (userRepository.existsByName(dto.getName())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
    }

    if (dto.getRole() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role is required");
    }

    String passwordHash = passwordEncoder.encode(dto.getPassword());

    User user = User.builder()
        .name(dto.getName())
        .role(dto.getRole())
        .password(passwordHash)
        .status(Status.ACTIVE)
        .build();
    user = userRepository.save(user);
    String jwt = jwtService.generateToken(user);
    return JwtResponseDTO.builder().token(jwt).build();
  }

  public JwtResponseDTO login(UserAuthenticationDTO dto) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
    User user = userRepository.findByName(dto.getName()).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + dto.getId())
    );
    String jwt = jwtService.generateToken(user);
    return JwtResponseDTO.builder().token(jwt).id(user.getId()).build();
  }

  public JwtResponseDTO update(UserAuthenticationDTO dto) {
    User user = userRepository.findById(dto.getId()).orElseThrow(
        () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "User not found with id: " + dto.getId()
        )
    );

    user.setName(dto.getName());

    if (dto.getPassword() != null) {
      String passwordHash = passwordEncoder.encode(dto.getPassword());
      user.setPassword(passwordHash);
    }

    userRepository.save(user);
    String jwt = jwtService.generateToken(user);

    return JwtResponseDTO.builder().token(jwt).build();
  }
}
