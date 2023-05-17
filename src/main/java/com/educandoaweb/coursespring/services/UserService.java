package com.educandoaweb.coursespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoaweb.coursespring.entities.User;
import com.educandoaweb.coursespring.repositories.UserRepository;
import com.educandoaweb.coursespring.services.exceptions.ResourceNotFoundException;
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
		//return obj.get(); tenta da um get e se o objeto do id não existir então lança a excessão
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
