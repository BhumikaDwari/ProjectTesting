package dev.bhumika.productservice;

import dev.bhumika.productservice.models.Product;
import dev.bhumika.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductserviceApplicationTests {

	@Autowired
	ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void testingQuery(){
	}

}
