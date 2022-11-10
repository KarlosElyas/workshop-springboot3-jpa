package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // classe e tipo do id (User, Long)
	// possui diversos metodos padroes
}
