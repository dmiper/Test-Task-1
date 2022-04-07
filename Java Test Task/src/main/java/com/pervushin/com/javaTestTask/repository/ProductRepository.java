package com.pervushin.com.javaTestTask.repository;

import com.pervushin.com.javaTestTask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}