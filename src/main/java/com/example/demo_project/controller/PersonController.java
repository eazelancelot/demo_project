package com.example.demo_project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonReq;
import com.example.demo_project.vo.PersonReq2;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping(value = "/api/getPerson")
	public List<Person> getPersonInfo() {
		List<Person> result = personService.getPersonInfo();
		
		return result;
	}
	
	@PostMapping(value = "/api/getPersonById")
	public Person findPersonById(@RequestBody PersonReq req) {
		Person per = personService.getPersonInfoById(req.getId());
		return per;
	}
	
	@PostMapping(value = "/api/getPersonByAge")
	public List<Person> getPersonInfoByAgeLargerThan(@RequestBody PersonReq req) {
		List<Person> result = personService.getPersonInfoByAgeLargerThan(req.getAge());
		
		return result;
	}
	
	@PostMapping(value = "/api/getPersonByNameLike")
	public List<Person> getPersonInfoByNameLike(@RequestBody PersonReq req) {
		List<Person> result = personService.getPersonInfoByNameLike(req.getName());
		
		return result;
	}
	
	@PostMapping(value = "/api/getPersonByNameSet")
	public List<Person> getPersonInfoByNameSet(@RequestBody PersonReq2 req) {
		Set<String> nameSet = req.getNameSet();
		System.out.println(nameSet);
		return null;
	}
}
