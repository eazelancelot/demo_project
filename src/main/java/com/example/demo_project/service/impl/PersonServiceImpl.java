package com.example.demo_project.service.impl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public List<Person> getPersonInfo() {
//		// init
//		Person p1 = new Person("A01", "AAA", 15);
//		Person p2 = new Person("A02", "BBB", 20);
//		Person p3 = new Person("A03", "CCC", 33);
		
		List<Person> list = personDao.findAll();
		return list;
	}

	@Override
	public Person getPersonInfoById(String id) {
		Optional<Person> personOp = personDao.findById(id);
//		if (personOp.isPresent()) {
////			Person per = personOp.get();
////			System.out.println(per.getId());
////			System.out.println(per.getAge());
//			return personOp.get();
//		} else {
//			return new Person();
//		}
		return personOp.orElse(new Person());
//		return personDao.findById(id).orElse(new Person());
		
//		List<Person> list = personDao.findAll();
//		for(Person item : list) {
//			if (item.getId().equalsIgnoreCase(id)) {
//				return item;
//			}
//		}
//		return new Person();
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		List<Person> list = personDao.findByAgeGreaterThan(age);
		return list;
//		List<Person> list = personDao.findAll();
//		List<Person> newList = new ArrayList<>();
//		for(Person item : list) {
//			if (item.getAge() > age) {
//				newList.add(item);
//			}
//		}
//		return newList;
	}
	
	@Override
	public List<Person> getPersonInfoByNameLike(String name) {
		List<Person> list = personDao.findByNameLike(name);
		return list;
//		List<Person> list = personDao.findAll();
//		List<Person> newList = new ArrayList<>();
//		for(Person item : list) {
//			if (item.getAge() > age) {
//				newList.add(item);
//			}
//		}
//		return newList;
	}

	@Override
	public Person create() {
		Person person = new Person();
		person.setId("A07");
		person.setName("FFG");
		person.setAge(25);
		person.setTime(LocalTime.of(9, 0));
		return personDao.save(person);
	}

}
