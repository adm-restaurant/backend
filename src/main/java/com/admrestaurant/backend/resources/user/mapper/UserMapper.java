package com.admrestaurant.backend.resources.user.mapper;

import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.resources.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "password", ignore = true)
  UserDTO toDTO(User user);

  User toEntity(UserDTO userDTO);
}
