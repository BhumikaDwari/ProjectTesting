package dev.bhumika.productservice.services;

import dev.bhumika.productservice.dtos.FakeStoreCategoryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public String[] getAllCategory(){
        String[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products/categories",String[].class);
        return response;

    }
}
