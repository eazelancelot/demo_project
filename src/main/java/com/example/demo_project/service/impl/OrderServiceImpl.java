package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Menu> getMenus() {
		// init
		Menu beefMenu = new Menu("beef", 100);
		Menu porkMenu = new Menu("pork", 90);
		Menu fishMenu = new Menu("fish", 120);
		// ====================================
		// find all menus from DB
		List<Menu> list = new ArrayList<>();
		list.add(beefMenu);
		list.add(porkMenu);
		list.add(fishMenu);
		// ====================================
		return list;
	}

	@Override
	public Menu getMenu(String name) {
		// init
		Menu beefMenu = new Menu("beef", 100);
		Menu porkMenu = new Menu("pork", 90);
		Menu fishMenu = new Menu("fish", 120);
		// ====================================
		// find menu by name
		if (name.equalsIgnoreCase(beefMenu.getName())) {
			return beefMenu;
		} else if (name.equalsIgnoreCase(porkMenu.getName())) {
			return porkMenu;
		} else if (name.equalsIgnoreCase(fishMenu.getName())) {
			return fishMenu;
		} else {
			return new Menu();
		}
		// find menu by name from DB
	}

}
