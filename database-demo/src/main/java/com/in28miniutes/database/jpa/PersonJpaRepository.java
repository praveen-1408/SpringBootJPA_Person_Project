package com.in28miniutes.database.jpa;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28miniutes.database.entity.Person;
@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}

	

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	

	public Person updatePerson(int id, String name, String location,Date birthDate) {
		Person person = findById(id);
		person.setName(name);
		person.setLocation(location);
		person.setBirthdate(birthDate);
		entityManager.merge(person);
		
		return person;
		
	}



	


}
