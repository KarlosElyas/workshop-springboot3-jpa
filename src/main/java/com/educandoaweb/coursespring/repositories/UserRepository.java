package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { // classe e tipo do id (User, Long)
	// possui diversos metodos padroes
}
