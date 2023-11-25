package com.admrestaurant.backend.services.authenticate.dto;

import com.admrestaurant.backend.entities.Role;
import com.admrestaurant.backend.resources.user.dto.UserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class JwtResponseDTO extends UserDTO {
	private final String token;

	@Builder
	public JwtResponseDTO(Long id, String name, String password,
			Role role, String token) {
		super(id, name, password, role);
		this.token = token;
	}
}
