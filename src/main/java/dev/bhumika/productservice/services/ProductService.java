package dev.bhumika.productservice.services;

import dev.bhumika.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(Long id);

    public Product createProduct(String title,
                                 String image,
                                 String description,
                                 String category,
                                 double price);

    public List<Product> getAllProduct();
}
