package dev.bhumika.productservice.dtos;

import dev.bhumika.productservice.models.Category;
import dev.bhumika.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private Double price;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        product.setPrice(getPrice());

        Category category = new Category();
        category.setTitle(getCategory());
        product.setCategory(category);

        return product;
    }
}

