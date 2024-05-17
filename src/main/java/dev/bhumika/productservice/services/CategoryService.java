package dev.bhumika.productservice.services;

import dev.bhumika.productservice.dtos.FakeStoreCategoryDto;
import dev.bhumika.productservice.models.Category;
import java.util.List;

public interface CategoryService {

    List<FakeStoreCategoryDto> getAllCategory();
}
