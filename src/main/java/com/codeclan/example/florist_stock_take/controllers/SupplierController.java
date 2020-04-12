package com.codeclan.example.florist_stock_take.controllers;


import com.codeclan.example.florist_stock_take.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity getAllSuppliers(){
        return new ResponseEntity(supplierRepository.findAll(), HttpStatus.OK);
    }
}
