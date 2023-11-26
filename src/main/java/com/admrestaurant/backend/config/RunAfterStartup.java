package com.admrestaurant.backend.config;

import com.admrestaurant.backend.entities.Role;
import com.admrestaurant.backend.services.user.UserService;
import com.admrestaurant.backend.services.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RunAfterStartup {

  private final UserService userService;

  @EventListener(ApplicationReadyEvent.class)
  public void runAfterStartup() {
    System.out.println("Hello World, I have just started up");

    this.userService.create(UserDTO.builder()
        .name("admin")
        .password("admin")
        .role(Role.ADMINISTRADOR)
        .build()
    );
  }
}
