package com.educandoaweb.coursespring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoaweb.coursespring.entities.Category;
import com.educandoaweb.coursespring.entities.Order;
import com.educandoaweb.coursespring.entities.OrderItem;
import com.educandoaweb.coursespring.entities.Payment;
import com.educandoaweb.coursespring.entities.Product;
import com.educandoaweb.coursespring.entities.User;
import com.educandoaweb.coursespring.entities.enums.OrderStatus;
import com.educandoaweb.coursespring.repositories.CategoryRepository;
import com.educandoaweb.coursespring.repositories.OrderItemRepository;
import com.educandoaweb.coursespring.repositories.OrderRepository;
import com.educandoaweb.coursespring.repositories.ProductRepository;
import com.educandoaweb.coursespring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // o proprio spring vai instacia o objeto assumindo a injecao de dependencia
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception { // metodo e executado assim que inicia a aplicacao

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		// para a persistencia dos registros no banco, produto é salvo duas vezes para
		// garantir
		// que os registros referenciados na associação existam

		// COMENTARIOS SÃO IMPORTANTES
		// o SET que é uma collection ta sendo usado para não repetir categorias iguais
		// dentro dele
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, u1); // ja associa o
																										// usuario
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		// ORDER = Pedido | ITEM = Produto
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); // o preço é variavel, hoje ele é um, amanha ja mudou
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1); // o jpa ja vai criar o registro do pagamento e associalo
		
	}

}
