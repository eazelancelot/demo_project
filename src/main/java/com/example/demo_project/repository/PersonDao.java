package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, String>{
	
	public List<Person> findByAgeGreaterThan(int age);
	
	public List<Person> findByNameAndAge(String name, int age);
	
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
	
	public List<Person> findByNameLike(String name);
	
	public List<Person> findByCity(String city);
	
	public List<Person> findBy();
}
