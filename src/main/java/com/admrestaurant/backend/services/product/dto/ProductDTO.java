package com.admrestaurant.backend.services.product.dto;

import com.admrestaurant.backend.entities.Category;
import lombok.Data;

@Data
public class ProductDTO {
  private Long id;
  private String name;
  private Double price;
  private Category category;
}
