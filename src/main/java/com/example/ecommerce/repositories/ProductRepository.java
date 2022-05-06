package com.example.ecommerce.repositories;

import com.example.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  boolean existsBySku(String sku);

  Product findBySku(String sku);
}
