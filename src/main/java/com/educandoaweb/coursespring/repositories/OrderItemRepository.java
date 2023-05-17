package com.educandoaweb.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoaweb.coursespring.entities.OrderItem;
import com.educandoaweb.coursespring.entities.User;

// @Repository não precisa da anotation para o injeção de dependencia pois JPA Repository ja tem uma que herda
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { // classe e tipo do id (User, Long)
	// 								Nesse caso o pk NÃO é long por ser pk composta mas mesmo assim continua long
}

//				ESSA INTERFACE É QUEM SE COMUNICA DIRETAMENTE COM O BANCO DE DADOS
