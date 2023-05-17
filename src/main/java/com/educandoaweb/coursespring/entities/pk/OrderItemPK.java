package com.educandoaweb.coursespring.entities.pk;

import java.util.Objects;

import com.educandoaweb.coursespring.entities.Order;
import com.educandoaweb.coursespring.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // classe auxiliar de chave primária COMPOSTA
public class OrderItemPK {
	
	@ManyToOne
	@JoinColumn(name = "order_id") // nome da chave estrangeira da tabela
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
}
