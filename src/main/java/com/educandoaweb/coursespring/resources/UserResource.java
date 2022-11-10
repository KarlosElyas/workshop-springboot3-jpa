package com.educandoaweb.coursespring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoaweb.coursespring.entities.User;
import com.educandoaweb.coursespring.services.UserService;

@RestController
@RequestMapping(value = "/users") // definido o endereco http do tipo GET
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping // requisicao tipo get (get/post)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); // e chamado a service que por sua vez chama a repository
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ // permite pegar o id da url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
