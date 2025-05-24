package com.github.manell98.produtosapi.controller;

import com.github.manell98.produtosapi.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping
    public Product create(@RequestBody Product product) {
        System.out.println("Created product: " + product);

        return product;
    }
}
