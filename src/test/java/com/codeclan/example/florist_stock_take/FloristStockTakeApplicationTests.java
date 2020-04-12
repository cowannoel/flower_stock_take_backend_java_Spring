package com.codeclan.example.florist_stock_take;

import com.codeclan.example.florist_stock_take.models.Product;
import com.codeclan.example.florist_stock_take.models.Supplier;
import com.codeclan.example.florist_stock_take.repositories.ProductRepository;
import com.codeclan.example.florist_stock_take.repositories.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class FloristStockTakeApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindAllSuppliers(){
		List<Supplier> foundSuppliers = supplierRepository.findAll();
		assertEquals(2, foundSuppliers.size());
		assertEquals("Jvan Vliet", foundSuppliers.get(0).getName());
	}

	@Test
	public void canFindProductBySupplier(){
		List<Product> foundProducts = productRepository.findBySupplierNameContainingIgnoreCase("vliet");
		assertEquals(2, foundProducts.size());
		assertEquals("flute vase 20cm", foundProducts.get(0).getName());
	}

}
