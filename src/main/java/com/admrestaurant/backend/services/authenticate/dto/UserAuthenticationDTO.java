package com.admrestaurant.backend.services.authenticate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthenticationDTO {
    private String password;
    private String nome;
}
