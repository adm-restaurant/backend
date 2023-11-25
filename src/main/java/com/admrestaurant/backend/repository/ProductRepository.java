package com.admrestaurant.backend.repository;

import com.admrestaurant.backend.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByNameLike(String name);

  List<Product> findByCategoryId(Long categoryId);
}
