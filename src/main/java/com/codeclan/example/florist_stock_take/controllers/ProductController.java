package com.codeclan.example.florist_stock_take.controllers;

import com.codeclan.example.florist_stock_take.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity getBySupplierName(@PathVariable String name){
        return new ResponseEntity(productRepository.findBySupplierNameContainingIgnoreCase(name), HttpStatus.OK);
    }
}
