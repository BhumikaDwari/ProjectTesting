package dev.bhumika.productservice.services;

import dev.bhumika.productservice.dtos.FakeStoreProductDto;
import dev.bhumika.productservice.models.Category;
import dev.bhumika.productservice.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity
                ("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,id);
        return responseEntity.getBody().toProduct();
    }

    @Override
    public Product createProduct(String title, String image, String description, String category, Double price){

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setTitle(title);

        FakeStoreProductDto response = restTemplate.postForObject
                ("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);

        return response.toProduct();
    }

    @Override
    public List<Product> getAllProduct(){

        FakeStoreProductDto[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: response){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product deleteProduct(Long id){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
       ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.exchange
               ("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE, requestEntity, FakeStoreProductDto.class, id);
       return fakeStoreProductDto.getBody().toProduct();

    }

    @Override
    public Product updateProduct(Long id,String title,
                                 String image,
                                 String description,
                                 String category,
                                 Double price) {
       FakeStoreProductDto currentProduct = restTemplate.getForObject
               ("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);
       if(title != null){
           currentProduct.setTitle(title);
       }
       if(image != null){
           currentProduct.setImage(image);
       }
       if(description != null){
           currentProduct.setDescription(description);
       }
       if(category != null){
           currentProduct.setCategory(category);
       }
       if(price != null){
           currentProduct.setPrice(price);
       }

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<FakeStoreProductDto> requestEntity = new HttpEntity<>(currentProduct, headers);
       ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.exchange
               ("https://fakestoreapi.com/products/{id}",
                       HttpMethod.PUT, requestEntity, FakeStoreProductDto.class, id);

       return fakeStoreProductDto.getBody().toProduct();
    }

    public List<Product> getProductByCategory(String title){
        FakeStoreProductDto[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products/category/{title}", FakeStoreProductDto[].class,title);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: response){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

}
