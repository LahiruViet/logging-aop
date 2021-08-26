package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping("/save")
    public List<Product> saveProducts(@RequestBody List<Product> products) {

        List<Product> pList = service.addProduct(products);
        return pList;
    }

    @GetMapping("/findProducts")
    public List<Product> getProducts() {

        List<Product> products = service.findAllProducts();
        return products;
    }

}
