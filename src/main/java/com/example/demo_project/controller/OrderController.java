package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.MenuRes;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/api/getMenus")
	public MenuRes getMenus() {
		MenuRes res = new MenuRes();
//		List<Menu> menuList = orderService.getMenus();
//		res.setMenuList(menuList);
		res.setMenuList(orderService.getMenus());	
		return res;	
	}

	@PostMapping(value = "/api/getMenu")
	public Menu getMenu(@RequestBody MenuReq req) {
//		Menu menu = orderService.getMenu(name);
//		return menu;
		return orderService.getMenu(req.getName());
	}
}
