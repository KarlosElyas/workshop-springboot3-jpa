package com.educandoaweb.coursespring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoaweb.coursespring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping // requisicao tipo get (get/post)
	public ResponseEntity<User> lookforAll(){
		return ResponseEntity.ok().body(new User(1L, "Maria", "maria@gmail", "009877", "amodsv"));
	}
}
