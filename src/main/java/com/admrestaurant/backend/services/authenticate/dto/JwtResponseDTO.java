package com.admrestaurant.backend.services.authenticate.dto;

import com.admrestaurant.backend.entities.Role;
import com.admrestaurant.backend.services.user.dto.UserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@SuperBuilder
public class JwtResponseDTO extends UserDTO {
	private final String token;
}
