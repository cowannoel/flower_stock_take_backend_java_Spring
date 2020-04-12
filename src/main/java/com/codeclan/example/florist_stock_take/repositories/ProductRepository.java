package com.codeclan.example.florist_stock_take.repositories;

import com.codeclan.example.florist_stock_take.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBySupplierNameContainingIgnoreCase(String supplier);




}
