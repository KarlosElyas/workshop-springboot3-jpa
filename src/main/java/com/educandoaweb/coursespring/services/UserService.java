package com.educandoaweb.coursespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoaweb.coursespring.entities.User;
import com.educandoaweb.coursespring.repositories.UserRepository;
											// Injeção de dependencia, acoplamento fraco
@Service // registra como componente do spring e permite utilizar o @Autowired dessa classe nas demais.
public class UserService {
// ESSA CLASSE é quem possui as REGRAS de négocio, como numero em estoque insuficiente e etc.
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
