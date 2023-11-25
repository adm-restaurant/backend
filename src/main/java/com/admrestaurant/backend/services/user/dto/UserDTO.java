package com.admrestaurant.backend.services.user.dto;

import com.admrestaurant.backend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String password;
  private Role role;
}
