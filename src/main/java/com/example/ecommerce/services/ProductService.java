package com.example.ecommerce.services;

import com.example.ecommerce.models.Product;
import java.util.List;

public interface ProductService {

  List<Product> queryProducts(Product product);

  Product getProductById(Long id);

  Product addProduct(Product product);

  Product updateProductById(Long id, Product product);

  void deleteProductById(Long id);

}
