package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Menu;

public interface OrderService {
	
	public List<Menu> getMenus(); //get all menus
	
	public Menu getMenu(String name); // get menu by name

}
