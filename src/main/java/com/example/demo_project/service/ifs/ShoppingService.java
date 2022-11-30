package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Product;

public interface ShoppingService {
	
	public void queryProducts(List<String> queryNameList, List<Product> productList);
	
	public String queryProducts(List<String> queryNameList);
	
	public void checkout(List<Product> productList);

}
