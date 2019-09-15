package com.example.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.orderservice.entity.Order;

@Component
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
