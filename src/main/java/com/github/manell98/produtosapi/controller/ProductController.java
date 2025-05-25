package com.github.manell98.produtosapi.controller;

import com.github.manell98.produtosapi.model.Product;
import com.github.manell98.produtosapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);
        log.info("Created new product with ID: {}", createdProduct.getId());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productRepository.findAll();
        log.info("Retrieved {} products", products.size());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    log.info("Found product with ID: {}", id);
                    return ResponseEntity.ok(product);
                })
                .orElseGet(() -> {
                    log.warn("Product with ID {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product productDetails) {

        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productDetails.getName());
                    existingProduct.setDescription(productDetails.getDescription());
                    existingProduct.setPrice(productDetails.getPrice());

                    Product updatedProduct = productRepository.save(existingProduct);
                    log.info("Updated product with ID: {}", id);

                    return ResponseEntity.ok(updatedProduct);
                })
                .orElseGet(() -> {
                    log.warn("Product with ID {} not found for update", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    log.info("Deleted product with ID: {}", id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> {
                    log.warn("Product with ID {} not found for deletion", id);
                    return ResponseEntity.notFound().build();
                });
    }
}
