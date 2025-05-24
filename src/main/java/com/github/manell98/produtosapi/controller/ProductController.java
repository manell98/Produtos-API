package com.github.manell98.produtosapi.controller;

import com.github.manell98.produtosapi.model.Product;
import com.github.manell98.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);

        System.out.println("Created product: " + createdProduct);

        return createdProduct;
    }
}
