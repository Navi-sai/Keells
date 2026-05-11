package com.KeellsOrder.KeellsOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KeellsOrder.KeellsOrder.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {

}
