package com.educandoaweb.coursespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoaweb.coursespring.entities.Order;
import com.educandoaweb.coursespring.repositories.OrderRepository;

@Service // registra como componente do spring e permite utilizar o @Autowired dessa classe nas demais.
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
