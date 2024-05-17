package dev.bhumika.productservice.services;

import dev.bhumika.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(Long id);

    public Product createProduct(String title,
                                 String image,
                                 String description,
                                 String category,
                                 Double price);

    public List<Product> getAllProduct();

    Product deleteProduct(Long id);

    Product updateProduct(Long id,String title,
                          String image,
                          String description,
                          String category,
                          Double price);

    List<Product> getProductByCategory(String title);
}
