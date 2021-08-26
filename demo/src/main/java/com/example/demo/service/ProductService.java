package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> addProduct(List<Product> products);

    List<Product> findAllProducts();

}
