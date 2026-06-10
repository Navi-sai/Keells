package com.KeellsOrder.KeellsOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KeellsOrder.KeellsOrder.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
