package com.admrestaurant.backend.resources.product;

import com.admrestaurant.backend.entities.Category;
import com.admrestaurant.backend.services.product.ProductService;
import com.admrestaurant.backend.services.product.dto.ProductDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductResource {
  private final ProductService productService;

  @GetMapping("/all")
  public List<ProductDTO> findAll() {
    return this.productService.findAll();
  }

  @GetMapping("/{category}")
  public List<ProductDTO> findByCategory(
      @PathVariable Category category
  ) {
    return this.productService.findByCategory(category);
  }

  @PostMapping
  public ProductDTO create(
      @RequestBody ProductDTO product
  ) {
    return this.productService.save(product);
  }

  @PutMapping
  public ProductDTO update(
      @RequestBody ProductDTO product
  ) {
    return this.productService.save(product);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable Long id
  ) {
    this.productService.delete(id);
  }
}
