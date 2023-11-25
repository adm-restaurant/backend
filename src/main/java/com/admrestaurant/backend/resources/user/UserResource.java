package com.admrestaurant.backend.resources.user;

import com.admrestaurant.backend.resources.user.dto.UserDTO;
import com.admrestaurant.backend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserResource {
  private final UserService userService;

  @PostMapping
  public UserDTO create(
      @RequestBody UserDTO user
  ) {
    return this.userService.create(user);
  }

  @PutMapping
  public UserDTO update(
      @RequestBody UserDTO user
  ) {
    return this.userService.update(user);
  }
}
