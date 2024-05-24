package dev.bhumika.productservice.services;

import dev.bhumika.productservice.models.Category;
import dev.bhumika.productservice.models.Product;
import dev.bhumika.productservice.repositories.CategoryRepository;
import dev.bhumika.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id){
        return productRepository.findByIdIs(id);
    }


    @Override
    public Product createProduct(String title,
                                 String image,
                                 String description,
                                 String categoryTitle,
                                 Double price){
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDatabase = categoryRepository.findByTitle(categoryTitle);
        if(categoryFromDatabase == null){
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            categoryFromDatabase = newCategory;
            //categoryFromDatabase = categoryRepository.save(newCategory);
        }
        product.setCategory(categoryFromDatabase);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Product deleteProduct(Long id){
        return null;

    }

    public Product updateProduct(Long id,String title,
                          String image,
                          String description,
                          String category,
                          Double price){
        return null;

        }

    public List<Product> getProductByCategory(String title){
        return null;

    }

}
