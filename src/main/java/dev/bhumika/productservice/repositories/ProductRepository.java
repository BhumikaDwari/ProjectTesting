package dev.bhumika.productservice.repositories;

import dev.bhumika.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);

    Product findByIdIs(Long id);

    List<Product> findAll();

    @Query("select p from Product where p.category.title = :title and p.id = :id")
    Product getProductWithSpecificTitleAndId(@Param("title") String title, @Param("id") Long id);
}
