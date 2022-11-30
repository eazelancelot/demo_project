package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.repository.WidgetDao;
import com.example.demo_project.service.ifs.WidgetService;

@Service
public class WidgetServiceImpl implements WidgetService {
	
	@Autowired
	private WidgetDao widgerDao;

	@Override
	public Widget save() {
		Widget widget = new Widget();
		widget.setName("AAA");
		return widgerDao.save(widget);
	}

}
