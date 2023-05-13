package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.User;

// @Repository não precisa da anotation para o injeção de dependencia pois JPA Repository ja tem uma que herda
public interface UserRepository extends JpaRepository<User, Long> { // classe e tipo do id (User, Long)
	// possui diversos metodos padroes
}

//				ESSA INTERFACE É QUEM SE COMUNICA DIRETAMENTE COM O BANCO DE DADOS
