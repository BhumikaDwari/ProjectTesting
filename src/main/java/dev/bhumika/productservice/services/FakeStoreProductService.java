package dev.bhumika.productservice.services;

import dev.bhumika.productservice.dtos.FakeStoreProductDto;
import dev.bhumika.productservice.models.Category;
import dev.bhumika.productservice.models.Product;
import org.springframework.http.ResponseEntity;
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





        //FakeStoreProductDto responseEntity = restTemplate.getForObject
             //   ("https://fakestoreapi.com/products/", FakeStoreProductDto.class, id);
        //return responseEntity.toProduct();

        //FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
//        Product product = new Product();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setImageUrl(fakeStoreProductDto.getImage());
//
//        Category category = new Category();
//        category.setTitle(fakeStoreProductDto.getTitle());
//        product.setCategory(category);
        //return product;


    }

    @Override
    public Product createProduct(String title, String image, String description, String category, double price){

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
}
