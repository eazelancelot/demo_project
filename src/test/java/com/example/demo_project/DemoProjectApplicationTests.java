package com.example.demo_project;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;

@SpringBootTest
class DemoProjectApplicationTests {

	@Autowired
	private PersonService personService;
	
	

	@Test
	public void contextLoads() {
		Person per = personService.getPersonInfo("TTTT");
		System.out.println(per.getId());
	}
	
	@Test
	public void activeTest() {
		
	}

}
