package com.oliveira.layered.arch.repository;

import com.oliveira.layered.arch.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
