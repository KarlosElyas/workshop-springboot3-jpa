package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { // classe e tipo do id (User, Long)
	// possui diversos metodos padroes
}
