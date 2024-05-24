package dev.bhumika.productservice.controllers;

import dev.bhumika.productservice.services.CategoryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<String[]> getAllCategory(){
        String[] responseData = categoryService.getAllCategory();
        ResponseEntity<String[]> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(200));
        return responseEntity;
    }
}
