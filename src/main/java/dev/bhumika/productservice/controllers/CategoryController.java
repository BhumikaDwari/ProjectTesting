package dev.bhumika.productservice.controllers;

import dev.bhumika.productservice.dtos.FakeStoreCategoryDto;
import dev.bhumika.productservice.models.Category;
import dev.bhumika.productservice.services.CategoryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<FakeStoreCategoryDto>> getAllCategory(){
        List<FakeStoreCategoryDto> responseData = categoryService.getAllCategory();
        ResponseEntity<List<FakeStoreCategoryDto>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(200));
        return responseEntity;
    }
}
