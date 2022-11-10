package com.educandoaweb.coursespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoaweb.coursespring.entities.Category;
import com.educandoaweb.coursespring.repositories.CategoryRepository;

@Service // registra como componente do spring e permite utilizar o @Autowired dessa classe nas demais.
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
