package com.admrestaurant.backend.services.user.mapper;

import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.services.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "password", ignore = true)
  UserDTO toDTO(User user);

  User toEntity(UserDTO userDTO);
}
