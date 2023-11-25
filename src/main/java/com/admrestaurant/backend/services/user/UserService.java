package com.admrestaurant.backend.services.user;

import com.admrestaurant.backend.entities.Status;
import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.repository.UserRepository;
import com.admrestaurant.backend.resources.user.dto.UserDTO;
import com.admrestaurant.backend.resources.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  public UserDTO create(UserDTO dto) {
    if (userRepository.existsByName(dto.getName())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
    }

    if (dto.getRole() == null ) {
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

    return userMapper.toDTO(user);
  }
  public UserDTO update(UserDTO dto) {
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

    return userMapper.toDTO(user);
  }
}
