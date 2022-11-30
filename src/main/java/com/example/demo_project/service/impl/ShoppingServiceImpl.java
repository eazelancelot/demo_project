package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Override
	public void queryProducts(List<String> queryNameList, List<Product> productList) {
		//琩高嘿ぃ眔
		if (queryNameList.isEmpty()) {
			System.out.println("琩高嘿ぃ眔");
			return;
		}
		Map<String, Product> queryMap = new HashMap<>();
		for (String nameItem : queryNameList) {
			for(Product productItem : productList) {
				if (nameItem.equalsIgnoreCase(productItem.getName())) {
					queryMap.put(nameItem, productItem);
					//"A1", null --> "A1", productItem
					break;
				} else {
					queryMap.put(nameItem, null);
					//           "A1", null
				}
			}		
		}
		for(Entry<String, Product> mapItem : queryMap.entrySet()) {
			if (mapItem.getValue() == null) {
				System.out.println(mapItem.getKey() + " 琩高礚挡狦");
			} else {
				Product product = mapItem.getValue();
				System.out.println("珇: " + product.getName() + ", 基: " + product.getPrice()
				+ ", 畐计秖: " + product.getStorage());
			}
		}
	}

	@Override
	public void checkout(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String queryProducts(List<String> queryNameList) {
		if (queryNameList.isEmpty()) {
			return "A";
		}
		return "B";	
	}

}
