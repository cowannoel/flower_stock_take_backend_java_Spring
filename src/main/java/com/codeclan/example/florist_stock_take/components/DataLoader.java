package com.codeclan.example.florist_stock_take.components;

import com.codeclan.example.florist_stock_take.models.Product;
import com.codeclan.example.florist_stock_take.models.Supplier;
import com.codeclan.example.florist_stock_take.repositories.ProductRepository;
import com.codeclan.example.florist_stock_take.repositories.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        Supplier vanVliet = new Supplier("Jvan Vliet", "22 Stenhouse Mill Wynd, Edinburgh EH11 3XX", "0131443228", "info@jvvc.co.uk");
        supplierRepository.save(vanVliet);

        Supplier countryBasket = new Supplier("Country Basket", "2297 Blochairn Road, Glasgow", "01415527781", "glasgow@countrybaskets.co.uk");
        supplierRepository.save(countryBasket);

        Supplier Heemskerk = new Supplier("Heemskerk", "holland", "53426", "h@h.h");
        supplierRepository.save(Heemskerk);



        Product product1 = new Product("flute vase 20cm", "clear flute vase 20cm", 12, 12, vanVliet, 5);
        productRepository.save(product1);

        Product product2 = new Product("flute vase 40cm", "clear flute vase 40cm", 12, 15, vanVliet, 5);
        productRepository.save(product2);

        Product product3 = new Product("lily vase 45cm", "clear long neck vase 45cm high", 9, 20, countryBasket, 10);
        productRepository.save(product3);

        Product product4 = new Product("dry oasis", "Regular block foam", 1, 2, Heemskerk, 25);
        productRepository.save(product4);
    }
}
