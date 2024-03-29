package com.ecommerce.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.engine.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
