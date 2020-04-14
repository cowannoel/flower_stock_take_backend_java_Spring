package com.codeclan.example.florist_stock_take.repositories;

import com.codeclan.example.florist_stock_take.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

   public List<Supplier> findAllByNameContainsIgnoreCase(String name);

//   Supplier findByStockNameContainsIgnoreCase(String name);

   List<Supplier> findDistinctByStockNameContainsIgnoreCase(String name);

//   Optional<Supplier> findById(Long id);


}
