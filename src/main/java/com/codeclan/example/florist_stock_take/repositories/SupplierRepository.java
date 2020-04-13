package com.codeclan.example.florist_stock_take.repositories;

import com.codeclan.example.florist_stock_take.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

   public List<Supplier> findAllByNameContainsIgnoreCase(String name);

//   Supplier findByStockNameContainsIgnoreCase(String name);

   List<Supplier> findDistinctByStockNameContainsIgnoreCase(String name);

//   public List<Supplier> findAllById(Long id);


}
