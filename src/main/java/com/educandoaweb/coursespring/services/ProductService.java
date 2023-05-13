package com.educandoaweb.coursespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoaweb.coursespring.entities.Product;
import com.educandoaweb.coursespring.repositories.ProductRepository;

@Service // registra como componente do spring e permite utilizar o @Autowired dessa classe nas demais.
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
