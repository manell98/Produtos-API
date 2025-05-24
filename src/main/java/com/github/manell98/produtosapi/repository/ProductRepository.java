package com.github.manell98.produtosapi.repository;

import com.github.manell98.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
