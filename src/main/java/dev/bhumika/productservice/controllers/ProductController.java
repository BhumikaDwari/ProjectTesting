package dev.bhumika.productservice.controllers;

import dev.bhumika.productservice.dtos.CreateProductRequestDto;
import dev.bhumika.productservice.models.Product;
import dev.bhumika.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto){
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getImage(),
                productRequestDto.getDescription(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> responseData = productService.getAllProduct();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(responseData , HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return  productService.getSingleProduct(id);
    }

    public void deleteProduct(Long id) {
    }


    //homework
//    Get all category
//    update a product , delete a product , get products in specific categories

}
