package com.example.orderservice.controller;

import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.entity.Order;

import java.util.List;

@Component
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;


	@PostMapping("/orders")
	public Order create(@RequestBody Order order)
	{
		return orderRepository.save(order);
	}


	@RequestMapping(method = RequestMethod.GET,value = "/orders")
	@ResponseBody
	public List<Order> findAll()
	{
		return orderRepository.findAll();
	}


	@PutMapping("/orders/{order_id}")
	public Order update(@PathVariable("order_id") Long orderId, @RequestBody Order orderObject)
	{
		Order order = orderRepository.findById(orderId).orElse(new Order());
		order.setOrderName(orderObject.getOrderName());
		order.setOrderType(orderObject.getOrderType());
		order.setOrderDescription(orderObject.getOrderDescription());
		return orderRepository.save(order);
	}



	@DeleteMapping("/orders/{order_id}")
	public List<Order> delete(@PathVariable("order_id") Long orderId)
	{
		orderRepository.deleteById(orderId);
		return orderRepository.findAll();
	}



	@GetMapping("/orders/{order_id}")
	@ResponseBody
	public Order findByOrderId(@PathVariable("order_id") Long orderId) throws Exception {
		return orderRepository.findById(orderId).orElseThrow(() -> new Exception("Order not found. Orderid: " + orderId));
	}
}
