package com.admrestaurant.backend.services.authenticate.dto;

import com.admrestaurant.backend.entities.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthenticationDTO {
    private Long id;
    private String password;
    private String name;
    private Role role;
}
