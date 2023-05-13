package com.educandoaweb.coursespring.entities.enums;

public enum OrderStatus {
// IMPORTANTISSIMO!!!! Essa Tabela/Entidade NÃO existe no banco de dados, apenas existe o numero do ENUM

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; // necessario para que funcione os numeros

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
