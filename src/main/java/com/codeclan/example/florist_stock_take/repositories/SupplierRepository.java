package com.codeclan.example.florist_stock_take.repositories;

import com.codeclan.example.florist_stock_take.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {


}
