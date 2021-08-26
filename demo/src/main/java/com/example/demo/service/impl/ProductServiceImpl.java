package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products;

    @PostConstruct
    public void initData() {

        products = Stream.of(new Product(101, "Book", 499),
                new Product(102, "laptop", 78000))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> addProduct(List<Product> products) {
        products.addAll(products);
        return products;
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

}
