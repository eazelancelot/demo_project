package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Person;

public interface PersonService {
	
	public List<Person> getPersonInfo();
	
	public Person getPersonInfoById(String id);
	
	public List<Person> getPersonInfoByAgeLargerThan(int age);
	
	public List<Person> getPersonInfoByNameLike(String name);
	
	public Person create();

}
