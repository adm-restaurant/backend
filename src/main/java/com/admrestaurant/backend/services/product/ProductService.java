package com.admrestaurant.backend.services.product;

import com.admrestaurant.backend.repository.ProductRepository;
import com.admrestaurant.backend.services.product.dto.ProductDTO;
import com.admrestaurant.backend.services.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
   private final ProductRepository productRepository;
   private final ProductMapper productMapper;

   public ProductDTO save(ProductDTO product) {
     var productEntity = this.productMapper.toEntity(product);
     this.productRepository.save(productEntity);
     return this.productMapper.toDTO(productEntity);
   }

   public void delete(Long id) {
     this.productRepository.deleteById(id);
   }
}
