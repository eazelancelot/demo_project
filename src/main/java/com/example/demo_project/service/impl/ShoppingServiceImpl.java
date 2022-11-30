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
		//�d�ߦW�٦C���o����
		if (queryNameList.isEmpty()) {
			System.out.println("�d�ߦW�٦C���o����");
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
				System.out.println(mapItem.getKey() + " �d�ߵL���G");
			} else {
				Product product = mapItem.getValue();
				System.out.println("�~�W: " + product.getName() + ", ����: " + product.getPrice()
				+ ", �w�s�ƶq: " + product.getStorage());
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
