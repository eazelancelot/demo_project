package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@SpringBootTest
public class ShoppingServiceTest {
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Test
	public void queryProductsTest() {
		//prepare
		Product p1 = new Product("A2", 20, 5);
		Product p2 = new Product("A1", 30, 2);
		Product p3 = new Product("B3", 50, 6);
		System.out.println("==================");
		List<Product> productList = new ArrayList<>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		List<String> queryNameList = new ArrayList<>();
//		queryNameList.add("A1");
//		queryNameList.add("B3");
//		queryNameList.add("C1");
		shoppingService.queryProducts(queryNameList, productList);
	}

}
