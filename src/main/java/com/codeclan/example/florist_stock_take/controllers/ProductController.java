package com.codeclan.example.florist_stock_take.controllers;

import com.codeclan.example.florist_stock_take.models.Product;
import com.codeclan.example.florist_stock_take.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>getProduct(@PathVariable Long id){
        return new ResponseEntity(productRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product>postProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> putProduct(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/suppliers/{name}")
    public ResponseEntity getBySupplierName(@PathVariable String name){
        return new ResponseEntity(productRepository.findBySupplierNameContainingIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping(value = "/products/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name){
        return new ResponseEntity(productRepository.findAllByNameContainingIgnoreCase(name),HttpStatus.OK);
    }
}
