package dev.bhumika.productservice.services;

import dev.bhumika.productservice.dtos.FakeStoreCategoryDto;
import dev.bhumika.productservice.dtos.FakeStoreProductDto;
import dev.bhumika.productservice.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{

    private RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<FakeStoreCategoryDto> getAllCategory(){

        FakeStoreCategoryDto[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products/categories", FakeStoreCategoryDto[].class);
        List<FakeStoreCategoryDto> category = new ArrayList<>();
        for(FakeStoreCategoryDto fakeStoreCategoryDto: response){
            category.add(fakeStoreCategoryDto);
        }
        return category;

    }
}
