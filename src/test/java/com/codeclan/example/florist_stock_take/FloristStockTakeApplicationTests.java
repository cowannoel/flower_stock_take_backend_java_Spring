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
import java.util.Optional;

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

	@Test
	public void canFindSupplierByName(){
		List<Supplier> foundSuppliers = supplierRepository.findAllByNameContainsIgnoreCase("vliet");
		assertEquals(1, foundSuppliers.size());
		assertEquals("Jvan Vliet", foundSuppliers.get(0).getName());

	}

//	@Test
//	public void canFindSupplierByProductName(){
//		Supplier supplier = supplierRepository.findByStockNameContainsIgnoreCase(" flute 20cm");
//		assertEquals("Jvan Vliet", supplier.getName());
//	}

	@Test
	public void candFindAllSuppliersStockingAKindOfItem(){
		List<Supplier> foundSuppliers = supplierRepository.findDistinctByStockNameContainsIgnoreCase("vase");
		assertEquals(2, foundSuppliers.size());
		assertEquals("Jvan Vliet", foundSuppliers.get(0).getName());
		assertEquals("Country Basket", foundSuppliers.get(1).getName());
	}

	@Test
	public void canFindAllItemsContainingAWord(){
		List<Product> foundProducts = productRepository.findAllByNameContainingIgnoreCase("vase");
		assertEquals(3, foundProducts.size());
		assertEquals("flute vase 20cm", foundProducts.get(0).getName());
		assertEquals("flute vase 40cm", foundProducts.get(1).getName());
		assertEquals("lily vase 45cm", foundProducts.get(2).getName());
	}

	@Test
	public void canFindById(){
		Optional<Supplier> supplier = supplierRepository.findById(1L);
		assertEquals("Jvan Vliet", supplier.get().getName());
	}

	@Test
	public void canDeleteById(){
		productRepository.deleteById(1L);
		assertEquals(2, supplierRepository.findAll().size());

	}

}
