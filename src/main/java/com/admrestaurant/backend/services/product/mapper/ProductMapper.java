package com.admrestaurant.backend.services.product.mapper;

import com.admrestaurant.backend.entities.Product;
import com.admrestaurant.backend.entities.User;
import com.admrestaurant.backend.services.product.dto.ProductDTO;
import com.admrestaurant.backend.services.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductDTO toDTO(Product user);

  Product toEntity(ProductDTO userDTO);
}
