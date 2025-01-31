package com.wipro.wipromart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.wipromart.entity.Product;
import com.wipro.wipromart.exception.ResourceNotFoundException;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Test
	void testGetProductById() {
		
		Product product = productService.getProductById(2);
		
		assertEquals("Samsung", product.getProductName());
		assertEquals(20000, product.getProductPrice());
	}
	
	@Test
	void testGetProductByIdWithException() {
				
		assertThrows(ResourceNotFoundException.class, ()-> productService.getProductById(35));
		
	}
}
