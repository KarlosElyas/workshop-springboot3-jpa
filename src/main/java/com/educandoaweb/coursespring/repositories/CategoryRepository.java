package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> { // classe e tipo do id (User, Long)
	// possui diversos metodos padroes
}
