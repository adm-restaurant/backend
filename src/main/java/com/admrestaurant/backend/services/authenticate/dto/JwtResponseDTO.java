package com.admrestaurant.backend.services.authenticate.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class JwtResponseDTO {
	private final Long id;
	private final String token;
}
