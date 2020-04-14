package com.codeclan.example.florist_stock_take.controllers;


import com.codeclan.example.florist_stock_take.models.Product;
import com.codeclan.example.florist_stock_take.models.Supplier;
import com.codeclan.example.florist_stock_take.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity getAllSuppliers(){
        return new ResponseEntity(supplierRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Supplier>getSupplier(@PathVariable Long id){
        return new ResponseEntity(supplierRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Supplier>postSupplier(@RequestBody Supplier supplier){
        supplierRepository.save(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Supplier> putSupplier(@RequestBody Supplier supplier){
        supplierRepository.save(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteSupplier(@PathVariable Long id){
        supplierRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/suppliers/{name}")
    public ResponseEntity<List<Supplier>> getAllSuppliersByName(@PathVariable String name){
        return new ResponseEntity(supplierRepository.findAllByNameContainsIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productName}")
    public ResponseEntity<List<Product>> getAllSuppliersByProductName(@PathVariable String productName){
        return new ResponseEntity(supplierRepository.findDistinctByStockNameContainsIgnoreCase(productName), HttpStatus.OK);
    }
}
