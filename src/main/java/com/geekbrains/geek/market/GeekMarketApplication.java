package com.geekbrains.geek.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class GeekMarketApplication {
	// Домашнее задание:
	// 1. На странице корзины делаем кнопку оформить заказ, нас перебрасывает на страницу,
	// где показываются товары из корзины, без возможности их менять
	// 2. На странице оформления заказа указывается имя клиента, его номер телефона, и адрес
	// доставки, по нажатию на кнопку оформить, заказ должен быть сохранен в базу данных

	public static void main(String[] args) {
		SpringApplication.run(GeekMarketApplication.class, args);
	}
}
