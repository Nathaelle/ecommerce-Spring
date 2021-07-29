package com.ecommerce.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.engine.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
